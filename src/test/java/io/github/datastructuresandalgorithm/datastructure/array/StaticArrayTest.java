
package io.github.datastructuresandalgorithm.datastructure.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticArrayTest {

    @Test
    void shouldUpdateFirstElement() {
        StaticArray array = new StaticArray(
                new int[]{10, 20, 30}
        );

        array.set(0, 99);

        assertEquals(99, array.get(0));
    }

    @Test
    void shouldUpdateLastElement() {
        StaticArray array = new StaticArray(
                new int[]{10, 20, 30}
        );

        array.set(2, 99);

        assertEquals(99, array.get(2));
    }

    @Test
    void shouldUpdateElementWithZero() {
        StaticArray array = new StaticArray(
                new int[]{10, 20, 30}
        );

        array.set(1, 0);

        assertEquals(0, array.get(1));
    }

    @Test
    void shouldUpdateElementWithNegativeValue() {
        StaticArray array = new StaticArray(
                new int[]{10, 20, 30}
        );

        array.set(1, -5);

        assertEquals(-5, array.get(1));
    }

    @Test
    void shouldThrowExceptionForNegativeIndex() {
        StaticArray array = new StaticArray(
                new int[]{10, 20, 30}
        );

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.set(-1, 99)
        );
    }

    @Test
    void shouldThrowExceptionForIndexEqualToCount() {
        StaticArray array = new StaticArray(
                new int[]{10, 20, 30}
        );

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.set(3, 99)
        );
    }

    @Test
    void shouldThrowExceptionWhenArrayIsEmpty() {
        StaticArray array = new StaticArray(new int[]{});

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.set(0, 99)
        );
    }

    @Test
    void shouldAllowUpdatingSameIndexMultipleTimes() {
        StaticArray array = new StaticArray(
                new int[]{10, 20, 30}
        );

        array.set(1, 50);
        array.set(1, 100);

        assertEquals(100, array.get(1));
    }

    @Test
    void shouldAllowUpdatingWithSameValue() {
        StaticArray array = new StaticArray(
                new int[]{10, 20, 30}
        );

        array.set(1, 20);

        assertEquals(20, array.get(1));
    }

    @Test
    void shouldNotAllowUpdatingUnusedCapacity() {
        StaticArray array = new StaticArray(5);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.set(0, 100)
        );
    }

    @Test
    void shouldAddFirstElement() {
        StaticArray array = new StaticArray(5);

        array.add(10);

        assertEquals(10, array.get(0));
    }

    @Test
    void shouldAddMultipleElements() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(30, array.get(2));
    }

    @Test
    void shouldAddZero() {
        StaticArray array = new StaticArray(3);

        array.add(0);

        assertEquals(0, array.get(0));
    }

    @Test
    void shouldAddNegativeValue() {
        StaticArray array = new StaticArray(3);

        array.add(-100);

        assertEquals(-100, array.get(0));
    }

    @Test
    void shouldThrowExceptionWhenArrayIsFull() {
        StaticArray array = new StaticArray(2);

        array.add(10);
        array.add(20);

        assertThrows(
                IllegalStateException.class,
                () -> array.add(30)
        );
    }

    @Test
    void shouldReportFullArrayCorrectly() {
        StaticArray array = new StaticArray(2);

        assertFalse(array.isFull());

        array.add(10);
        assertFalse(array.isFull());

        array.add(20);
        assertTrue(array.isFull());
    }



    @Test
    void shouldPreserveExistingElementsWhenAddingNewElement() {
        StaticArray array = new StaticArray(4);

        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
        assertEquals(30, array.get(2));
    }


    @Test
    void shouldInsertAtBeginning() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);
        array.add(30);

        array.insert(0, 99);

        assertArrayEquals(
                new int[]{99, 10, 20, 30},
                toArray(array, 4)
        );
    }

    @Test
    void shouldInsertInMiddle() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);
        array.add(30);

        array.insert(1, 99);

        assertEquals(10, array.get(0));
        assertEquals(99, array.get(1));
        assertEquals(20, array.get(2));
        assertEquals(30, array.get(3));
    }

    @Test
    void shouldInsertAtEnd() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);
        array.add(30);

        array.insert(3, 99);

        assertEquals(99, array.get(3));
    }

    @Test
    void shouldInsertIntoEmptyArray() {
        StaticArray array = new StaticArray(5);

        array.insert(0, 99);

        assertEquals(99, array.get(0));
    }



    @Test
    void shouldThrowExceptionForIndexGreaterThanCount() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> array.insert(3, 99)
        );
    }



    @Test
    void shouldInsertNegativeValue() {
        StaticArray array = new StaticArray(3);

        array.insert(0, -99);

        assertEquals(-99, array.get(0));
    }

    @Test
    void shouldInsertZero() {
        StaticArray array = new StaticArray(3);

        array.insert(0, 0);

        assertEquals(0, array.get(0));
    }

    private int[] toArray(StaticArray array, int size) {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = array.get(i);
        }

        return result;
    }

    @Test
    void shouldRemoveFirstElement() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        array.remove(0);

        assertEquals(20, array.get(0));
        assertEquals(30, array.get(1));
    }

    @Test
    void shouldRemoveMiddleElement() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);
        array.add(40);

        array.remove(1);

        assertEquals(10, array.get(0));
        assertEquals(30, array.get(1));
        assertEquals(40, array.get(2));
    }

    @Test
    void shouldRemoveLastElement() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        array.remove(2);

        assertEquals(10, array.get(0));
        assertEquals(20, array.get(1));
    }

    @Test
    void shouldRemoveOnlyElement() {
        StaticArray array = new StaticArray(5);
        array.add(10);

        array.remove(0);

        assertTrue(array.isEmpty());
    }

    @Test
    void shouldThrowExceptionWhenRemovingFromEmptyArray() {
        StaticArray array = new StaticArray(5);

        assertThrows(
                IllegalStateException.class,
                () -> array.remove(0)
        );
    }





    @Test
    void shouldAllowAddingAfterRemoval() {
        StaticArray array = new StaticArray(3);
        array.add(10);
        array.add(20);
        array.add(30);

        array.remove(1);
        array.add(40);

        assertEquals(40, array.get(2));
    }

    @Test
    void shouldHandleRemovingElementsWithZeroAndNegativeValues() {
        StaticArray array = new StaticArray(4);
        array.add(-10);
        array.add(0);
        array.add(20);

        array.remove(1);

        assertEquals(-10, array.get(0));
        assertEquals(20, array.get(1));
    }

    @Test
    void shouldFindFirstElement() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(0, array.search(10));
    }

    @Test
    void shouldFindMiddleElement() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(1, array.search(20));
    }

    @Test
    void shouldFindLastElement() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(2, array.search(30));
    }

    @Test
    void shouldReturnMinusOneWhenElementNotFound() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(-1, array.search(99));
    }

    @Test
    void shouldReturnFirstOccurrenceWhenDuplicatesExist() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(10);
        array.add(30);

        assertEquals(0, array.search(10));
    }

    @Test
    void shouldReturnMinusOneForEmptyArray() {
        StaticArray array = new StaticArray(5);

        assertEquals(-1, array.search(10));
    }

    @Test
    void shouldSearchZeroCorrectly() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(0);
        array.add(30);

        assertEquals(1, array.search(0));
    }

    @Test
    void shouldSearchNegativeValueCorrectly() {
        StaticArray array = new StaticArray(5);
        array.add(-10);
        array.add(20);
        array.add(-30);

        assertEquals(2, array.search(-30));
    }

    @Test
    void shouldNotSearchUnusedCapacity() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);

        assertEquals(-1, array.search(0));
    }


    @Test
    void shouldReturnTrueWhenElementExists() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        assertTrue(array.contains(20));
    }

    @Test
    void shouldReturnFalseWhenElementDoesNotExist() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        assertFalse(array.contains(99));
    }

    @Test
    void shouldReturnFalseForEmptyArray() {
        StaticArray array = new StaticArray(5);

        assertFalse(array.contains(10));
    }

    @Test
    void shouldReturnTrueForFirstElement() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        assertTrue(array.contains(10));
    }

    @Test
    void shouldReturnTrueForLastElement() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        assertTrue(array.contains(30));
    }

    @Test
    void shouldHandleZeroCorrectly() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(0);
        array.add(30);

        assertTrue(array.contains(0));
    }

    @Test
    void shouldHandleNegativeValues() {
        StaticArray array = new StaticArray(5);
        array.add(-10);
        array.add(20);

        assertTrue(array.contains(-10));
    }

    @Test
    void shouldIgnoreUnusedCapacity() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);

        assertFalse(array.contains(0));
    }

    @Test
    void shouldReturnZeroForEmptyArray() {
        StaticArray array = new StaticArray(5);

        assertEquals(0, array.size());
    }

    @Test
    void shouldReturnCorrectSizeAfterAddingElements() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(3, array.size());
    }

    @Test
    void shouldReturnCorrectSizeAfterInsertion() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);
        array.insert(1, 99);

        assertEquals(3, array.size());
    }

    @Test
    void shouldReturnCorrectSizeAfterRemoval() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);
        array.add(30);

        array.remove(1);

        assertEquals(2, array.size());
    }

    @Test
    void shouldReturnZeroAfterRemovingAllElements() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);

        array.remove(0);
        array.remove(0);

        assertEquals(0, array.size());
    }

    @Test
    void shouldNotReturnCapacityAsSize() {
        StaticArray array = new StaticArray(10);

        array.add(10);
        array.add(20);

        assertEquals(2, array.size());
        assertNotEquals(10, array.size());
    }


    @Test
    void shouldReturnInitialCapacity() {
        StaticArray array = new StaticArray(10);

        assertEquals(10, array.capacity());
    }

    @Test
    void shouldReturnCapacityAfterAddingElements() {
        StaticArray array = new StaticArray(10);

        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(10, array.capacity());
    }

    @Test
    void shouldMaintainCapacityAfterInsertion() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);
        array.insert(1, 99);

        assertEquals(5, array.capacity());
    }

    @Test
    void shouldMaintainCapacityAfterRemoval() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);
        array.remove(0);

        assertEquals(5, array.capacity());
    }

    @Test
    void shouldAllowZeroCapacity() {
        StaticArray array = new StaticArray(0);

        assertEquals(0, array.capacity());
    }

    @Test
    void shouldReturnTrueForNewEmptyArray() {
        StaticArray array = new StaticArray(5);

        assertTrue(array.isEmpty());
    }

    @Test
    void shouldReturnFalseAfterAddingElement() {
        StaticArray array = new StaticArray(5);

        array.add(10);

        assertFalse(array.isEmpty());
    }

    @Test
    void shouldReturnTrueAfterRemovingAllElements() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);

        array.remove(0);
        array.remove(0);

        assertTrue(array.isEmpty());
    }

    @Test
    void shouldReturnTrueForZeroCapacityArray() {
        StaticArray array = new StaticArray(0);

        assertTrue(array.isEmpty());
    }

    @Test
    void shouldReturnFalseForNewArray() {
        StaticArray array = new StaticArray(5);

        assertFalse(array.isFull());
    }

    @Test
    void shouldReturnFalseWhenPartiallyFilled() {
        StaticArray array = new StaticArray(5);

        array.add(10);
        array.add(20);

        assertFalse(array.isFull());
    }

    @Test
    void shouldReturnTrueWhenArrayIsFull() {
        StaticArray array = new StaticArray(3);

        array.add(10);
        array.add(20);
        array.add(30);

        assertTrue(array.isFull());
    }

    @Test
    void shouldReturnFalseAfterRemovingElementFromFullArray() {
        StaticArray array = new StaticArray(2);

        array.add(10);
        array.add(20);

        array.remove(0);

        assertFalse(array.isFull());
    }


    @Test
    void shouldClearAllElements() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);
        array.add(30);

        array.clear();

        assertEquals(0, array.size());
        assertTrue(array.isEmpty());
    }

    @Test
    void shouldPreserveCapacityAfterClear() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);

        array.clear();

        assertEquals(5, array.capacity());
    }

    @Test
    void shouldNotFindElementsAfterClear() {
        StaticArray array = new StaticArray(5);
        array.add(10);
        array.add(20);

        array.clear();

        assertEquals(-1, array.search(10));
        assertFalse(array.contains(20));
    }

    @Test
    void shouldAllowAddingElementsAfterClear() {
        StaticArray array = new StaticArray(3);
        array.add(10);
        array.add(20);

        array.clear();
        array.add(100);

        assertEquals(1, array.size());
        assertEquals(100, array.get(0));
    }

    @Test
    void shouldClearAnAlreadyEmptyArray() {
        StaticArray array = new StaticArray(5);

        array.clear();

        assertTrue(array.isEmpty());
        assertEquals(0, array.size());
    }

    @Test
    void shouldClearZeroCapacityArray() {
        StaticArray array = new StaticArray(0);

        array.clear();

        assertTrue(array.isEmpty());
        assertEquals(0, array.capacity());
    }
    @Test
    void shouldCreateIndependentCopyOfInputArray() {
        int[] original = {10, 20, 30};

        StaticArray array = new StaticArray(original);

        original[0] = 999;

        assertEquals(10, array.get(0));

        array.set(1, 888);

        assertEquals(20, original[1]);
    }



}
