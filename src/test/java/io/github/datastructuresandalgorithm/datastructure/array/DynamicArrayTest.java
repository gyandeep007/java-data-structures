package io.github.datastructuresandalgorithm.datastructure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void shouldCreateArrayWithRequestedCapacity() {
        DynamicArray array = new DynamicArray(5);

        assertEquals(5, array.capacity());
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
        assertFalse(array.isFull());
    }

    @Test
    void shouldSupportZeroCapacity() {
        DynamicArray array = new DynamicArray(0);

        assertEquals(0, array.capacity());
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
        assertTrue(array.isFull());
    }

    @Test
    void shouldCreateArrayWithCapacityOne() {
        DynamicArray array = new DynamicArray(1);

        assertEquals(1, array.capacity());
        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
        assertFalse(array.isFull());
    }

    @Test
    void shouldRejectNegativeCapacity() {
        assertThrows(
                NegativeArraySizeException.class,
                () -> new DynamicArray(-1)
        );
    }

    @Test
    void shouldRejectLargeNegativeCapacity() {
        assertThrows(
                NegativeArraySizeException.class,
                () -> new DynamicArray(-100)
        );
    }
    @Test
    void shouldGetElementAtValidIndex() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(30, array.get(2));
    }

    @Test
    void shouldGetElementAtLastValidIndex() {
        DynamicArray array = new DynamicArray(3);
        array.add(100);
        array.add(200);
        array.add(300);

        assertEquals(300, array.get(2));
    }

    @Test
    void shouldThrowExceptionForNegativeGetIndex() {
        DynamicArray array = new DynamicArray(3);
        array.add(10);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.get(-1)
        );
    }

    @Test
    void shouldThrowExceptionWhenGetIndexEqualsSize() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.get(2)
        );
    }

    @Test
    void shouldThrowExceptionWhenGettingFromEmptyArray() {
        DynamicArray array = new DynamicArray(5);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.get(0)
        );
    }

    @Test
    void shouldSetElementAtValidIndex() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        array.set(1, 99);

        assertEquals(99, array.get(1));
    }

    @Test
    void shouldNotChangeSizeAfterSet() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);

        int originalSize = array.size();

        array.set(0, 99);

        assertEquals(originalSize, array.size());
    }

    @Test
    void shouldThrowExceptionForNegativeSetIndex() {
        DynamicArray array = new DynamicArray(3);
        array.add(10);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.set(-1, 99)
        );
    }

    @Test
    void shouldThrowExceptionWhenSetIndexEqualsSize() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.set(2, 99)
        );
    }

    @Test
    void shouldThrowExceptionWhenSettingInEmptyArray() {
        DynamicArray array = new DynamicArray(5);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.set(0, 99)
        );
    }
    @Test
    void shouldAddElementWhenCapacityAvailable() {
        DynamicArray array = new DynamicArray(5);

        array.add(10);

        assertEquals(1, array.size());
        assertEquals(5, array.capacity());
        assertEquals(10, array.get(0));
    }

    @Test
    void shouldAddMultipleElementsWithoutResizing() {
        DynamicArray array = new DynamicArray(5);

        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(3, array.size());
        assertEquals(5, array.capacity());

        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(30, array.get(2));
    }

    @Test
    void shouldGrowCapacityWhenArrayIsFull() {
        DynamicArray array = new DynamicArray(2);

        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(3, array.size());
        assertEquals(4, array.capacity());
    }

    @Test
    void shouldDoubleCapacityWhenGrowing() {
        DynamicArray array = new DynamicArray(2);

        array.add(10);
        array.add(20);

        assertEquals(2, array.capacity());

        array.add(30);

        assertEquals(4, array.capacity());

        array.add(40);
        assertEquals(4, array.capacity());

        array.add(50);

        assertEquals(8, array.capacity());
    }

    @Test
    void shouldPreserveElementsAfterResize() {
        DynamicArray array = new DynamicArray(2);

        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(30, array.get(2));
    }

    @Test
    void shouldGrowZeroCapacityArrayWhenFirstElementIsAdded() {
        DynamicArray array = new DynamicArray(0);

        assertEquals(0, array.capacity());

        array.add(10);

        assertEquals(1, array.size());
        assertEquals(1, array.capacity());
        assertEquals(10, array.get(0));
    }

    @Test
    void shouldGrowCapacityFromOneToTwo() {
        DynamicArray array = new DynamicArray(1);

        array.add(10);
        array.add(20);

        assertEquals(2, array.size());
        assertEquals(2, array.capacity());
        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
    }

    @Test
    void shouldAddManyElementsAndGrowCorrectly() {
        DynamicArray array = new DynamicArray(1);

        for (int i = 1; i <= 100; i++) {
            array.add(i);
        }

        assertEquals(100, array.size());
        assertTrue(array.capacity() >= 100);

        for (int i = 0; i < 100; i++) {
            assertEquals(i + 1, array.get(i));
        }
    }

    @Test
    void shouldNotGrowCapacityWhenThereIsAvailableSpace() {
        DynamicArray array = new DynamicArray(10);

        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(10, array.capacity());
    }

    @Test
    void shouldCorrectlyMaintainSizeAfterMultipleResizes() {
        DynamicArray array = new DynamicArray(2);

        for (int i = 0; i < 20; i++) {
            array.add(i);
        }

        assertEquals(20, array.size());

        for (int i = 0; i < 20; i++) {
            assertEquals(i, array.get(i));
        }
    }
    @Test
    void shouldInsertAtBeginning() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        array.insert(0, 5);

        assertEquals(4, array.size());
        assertEquals(5, array.get(0));
        assertEquals(10, array.get(1));
        assertEquals(20, array.get(2));
        assertEquals(30, array.get(3));
    }

    @Test
    void shouldInsertInMiddle() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(40);

        array.insert(2, 99);

        assertEquals(5, array.size());
        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(99, array.get(2));
        assertEquals(30, array.get(3));
        assertEquals(40, array.get(4));
    }

    @Test
    void shouldInsertAtEnd() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);

        array.insert(array.size(), 30);

        assertEquals(3, array.size());
        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(30, array.get(2));
    }

    @Test
    void shouldGrowWhenInsertingIntoFullArray() {
        DynamicArray array = new DynamicArray(2);
        array.add(10);
        array.add(20);

        array.insert(1, 99);

        assertEquals(3, array.size());
        assertEquals(4, array.capacity());
        assertEquals(10, array.get(0));
        assertEquals(99, array.get(1));
        assertEquals(20, array.get(2));
    }

    @Test
    void shouldInsertIntoZeroCapacityArray() {
        DynamicArray array = new DynamicArray(0);

        array.insert(0, 100);

        assertEquals(1, array.size());
        assertEquals(1, array.capacity());
        assertEquals(100, array.get(0));
    }

    @Test
    void shouldThrowExceptionForNegativeInsertIndex() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.insert(-1, 99)
        );
    }

    @Test
    void shouldThrowExceptionWhenInsertIndexIsGreaterThanSize() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.insert(2, 99)
        );
    }

    @Test
    void shouldAllowInsertAtSizeOfEmptyArray() {
        DynamicArray array = new DynamicArray(3);

        array.insert(0, 50);

        assertEquals(1, array.size());
        assertEquals(50, array.get(0));
    }

    @Test
    void shouldPreserveElementsAfterMultipleInsertions() {
        DynamicArray array = new DynamicArray(2);
        array.add(10);
        array.add(30);

        array.insert(1, 20);
        array.insert(0, 5);
        array.insert(array.size(), 40);

        assertEquals(5, array.size());

        assertEquals(5, array.get(0));
        assertEquals(10, array.get(1));
        assertEquals(20, array.get(2));
        assertEquals(30, array.get(3));
        assertEquals(40, array.get(4));
    }
    @Test
    void shouldRemoveElementFromBeginning() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        array.remove(0);

        assertEquals(2, array.size());
        assertEquals(20, array.get(0));
        assertEquals(30, array.get(1));
    }

    @Test
    void shouldRemoveElementFromMiddle() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(40);

        array.remove(1);

        assertEquals(3, array.size());
        assertEquals(10, array.get(0));
        assertEquals(30, array.get(1));
        assertEquals(40, array.get(2));
    }

    @Test
    void shouldRemoveElementFromEnd() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        array.remove(2);

        assertEquals(2, array.size());
        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
    }

    @Test
    void shouldRemoveOnlyElement() {
        DynamicArray array = new DynamicArray(5);
        array.add(100);

        array.remove(0);

        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenRemovingFromEmptyArray() {
        DynamicArray array = new DynamicArray(5);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.remove(0)
        );
    }

    @Test
    void shouldThrowExceptionForNegativeRemoveIndex() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.remove(-1)
        );
    }

    @Test
    void shouldThrowExceptionWhenRemoveIndexEqualsSize() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.remove(2)
        );
    }

    @Test
    void shouldThrowExceptionWhenRemoveIndexIsGreaterThanSize() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.remove(5)
        );
    }

    @Test
    void shouldPreserveRemainingElementsAfterMultipleRemovals() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(40);
        array.add(50);

        array.remove(1);
        array.remove(2);
        array.remove(0);

        assertEquals(2, array.size());
        assertEquals(30, array.get(0));
        assertEquals(50, array.get(1));
    }
    @Test
    void searchReturnsFirstOccurrenceOfDuplicate() {
        DynamicArray array = new DynamicArray(5);
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(20);

        assertEquals(1, array.search(20));
    }
}