import data.File;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateFileFinderTest {

    @Test
    void testFindDuplicates() {
        File first = new File("first.txt", "Hello World");
        File second = new File("second.txt", "Hello World");
        File third = new File("third.mov", "234098234234589349");

        final DuplicateFileFinder duplicateFileFinder = new DuplicateFileFinder();
        final List<DuplicateFileFinder.Duplicate> duplicates = duplicateFileFinder.findDuplicates(first, second, third);

        DuplicateFileFinder.Duplicate expectedDuplicate = new DuplicateFileFinder.Duplicate(first, second);
        assertThat(duplicates).containsOnly(expectedDuplicate);
    }

}
