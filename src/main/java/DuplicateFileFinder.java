import data.File;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class DuplicateFileFinder {

    private final Map<String, File> knownHashes = new HashMap<>();

    public List<Duplicate> findDuplicates(File... files) {
        List<Duplicate> duplicates = new ArrayList<>();

        for (File file : files) {
            String hash = hashFile(file);
            if (knownHashes.containsKey(hash)) {
                duplicates.add(new Duplicate(knownHashes.get(hash), file));
            } else {
                knownHashes.put(hash, file);
            }
        }

        return  duplicates;
    }

    private String hashFile(File file) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("huh, no md5?");
        }
        md.update(file.getContent().getBytes(StandardCharsets.UTF_8));
        final byte[] hash = md.digest();

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02X", b));
        }
        final String hashString = sb.toString();
        System.out.println("file " + file + " hash: " + hashString);
        return hashString;
    }

    public static class Duplicate {
        private final File original;
        private final File duplicate;

        public Duplicate(File original, File duplicate) {
            this.original = original;
            this.duplicate = duplicate;
        }

        @Override
        public String toString() {
            return "Duplicate{" +
                    "original=" + original +
                    ", duplicate=" + duplicate +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Duplicate duplicate1 = (Duplicate) o;
            return original.equals(duplicate1.original) &&
                    duplicate.equals(duplicate1.duplicate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(original, duplicate);
        }

        public File getOriginal() {
            return original;
        }

        public File getDuplicate() {
            return duplicate;
        }

    }

}
