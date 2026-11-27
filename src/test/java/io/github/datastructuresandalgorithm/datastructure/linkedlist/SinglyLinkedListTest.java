package io.github.datastructuresandalgorithm.datastructure.linkedlist;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    @Test
    void addFirstShouldInsertIntoEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(10);

        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }
    @Test
    void addFirstShouldIncreaseSize() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
    }
    @Test
    void addFirstShouldSupportMultipleInsertions() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        // Expected logical order:
        // 30 → 20 → 10

        assertEquals(3, list.size());
    }

    @Test
    void getFirstShouldReturnFirstElement() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        assertEquals(30, list.getFirst());
    }
    @Test
    void getFirstShouldWorkWithSingleElement() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(42);

        assertEquals(42, list.getFirst());
    }
    @Test
    void getFirstShouldNotModifyList() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(10);
        list.addFirst(20);

        int sizeBefore = list.size();

        assertEquals(20, list.getFirst());

        assertEquals(sizeBefore, list.size());
        assertFalse(list.isEmpty());
        assertEquals(20, list.getFirst());
    }
    @Test
    void addLastShouldInsertIntoEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);

        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals(10, list.getFirst());
    }
    @Test
    void addLastShouldIncreaseSize() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(3, list.size());
        assertEquals(10, list.getFirst());
    }
    @Test
    void addFirstAndAddLastShouldWorkTogether() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(20);
        list.addFirst(10);
        list.addLast(30);
        list.addLast(40);

        assertEquals(4, list.size());
        assertEquals(10, list.getFirst());
    }

    private String captureOutput(SinglyLinkedList list) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(output));
            list.printList();
        } finally {
            System.setOut(originalOut);
        }

        return output.toString().trim();
    }

    @Test
    void printList_whenEmpty_shouldPrintNull() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertEquals("null", captureOutput(list));
    }

    @Test
    void printList_whenSingleElement_shouldPrintElementAndNull() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);

        assertEquals("10 -> null", captureOutput(list));
    }

    @Test
    void printList_whenMultipleElements_shouldPrintAllElements() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals("10 -> 20 -> 30 -> null", captureOutput(list));
    }
    @Test
    void get_whenIndexIsZero_shouldReturnFirstElement() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(10, list.get(0));
    }

    @Test
    void get_whenIndexIsMiddle_shouldReturnCorrectElement() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        assertEquals(30, list.get(2));
    }

    @Test
    void get_whenIndexIsLast_shouldReturnLastElement() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(30, list.get(2));
    }

    @Test
    void get_whenIndexIsNegative_shouldThrowException() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(-1)
        );
    }

    @Test
    void get_whenIndexEqualsSize_shouldThrowException() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(2)
        );
    }

    @Test
    void get_whenListIsEmpty_shouldThrowException() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.get(0)
        );
    }
    @Test
    void insert_whenEmpty_shouldInsertFirstElement() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(0, 10);

        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void insert_atBeginning_shouldInsertBeforeHead() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.insert(0, 5);

        assertEquals(4, list.size());
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(30, list.get(3));
    }

    @Test
    void insert_inMiddle_shouldInsertAtCorrectPosition() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.insert(2, 25);

        assertEquals(5, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(25, list.get(2));
        assertEquals(30, list.get(3));
        assertEquals(40, list.get(4));
    }

    @Test
    void insert_atEnd_shouldAppendElement() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.insert(3, 40);

        assertEquals(4, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
    }

    @Test
    void insert_whenIndexIsNegative_shouldThrowException() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.insert(-1, 5)
        );
    }

    @Test
    void insert_whenIndexGreaterThanSize_shouldThrowException() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.insert(3, 30)
        );
    }
    @Test
    void removeFirst_whenEmpty_shouldThrowException() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(
                IllegalStateException.class,
                list::removeFirst
        );
    }

    @Test
    void removeFirst_whenSingleElement_shouldReturnElementAndEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);

        int removed = list.removeFirst();

        assertEquals(10, removed);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void removeFirst_whenMultipleElements_shouldRemoveHead() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        int removed = list.removeFirst();

        assertEquals(10, removed);
        assertEquals(2, list.size());
        assertEquals(20, list.getFirst());
        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void removeFirst_multipleTimes_shouldRemoveElementsInOrder() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(10, list.removeFirst());
        assertEquals(20, list.removeFirst());
        assertEquals(30, list.removeFirst());

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        assertThrows(
                IllegalStateException.class,
                list::removeFirst
        );
    }
    @Test
    void removeLast_whenEmpty_shouldThrowException() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(
                IllegalStateException.class,
                list::removeLast
        );
    }

    @Test
    void removeLast_whenSingleElement_shouldReturnElementAndEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(10);

        int removed = list.removeLast();

        assertEquals(10, removed);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void removeLast_whenMultipleElements_shouldRemoveLastElement() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        int removed = list.removeLast();

        assertEquals(30, removed);
        assertEquals(2, list.size());

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void removeLast_multipleTimes_shouldRemoveElementsInReverseOrder() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(30, list.removeLast());
        assertEquals(20, list.removeLast());
        assertEquals(10, list.removeLast());

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        assertThrows(
                IllegalStateException.class,
                list::removeLast
        );
    }
    @Test
    void removeFromEmptyListThrowsException() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.remove(0)
        );
    }

    @Test
    void removeFirstElement() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(10, list.remove(0));

        assertEquals(2, list.size());
        assertEquals(20, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void removeMiddleElement() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        assertEquals(30, list.remove(2));

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(40, list.get(2));
    }

    @Test
    void removeLastElement() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(30, list.remove(2));

        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void removeSingleElementList() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(100);

        assertEquals(100, list.remove(0));

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void removeNegativeIndexThrowsException() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.remove(-1)
        );
    }

    @Test
    void removeIndexEqualToSizeThrowsException() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);

        assertThrows(
                IndexOutOfBoundsException.class,
                () -> list.remove(2)
        );
    }
    @Test
    void searchValueAtHead() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(0, list.search(10));
    }

    @Test
    void searchValueInMiddle() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        assertEquals(2, list.search(30));
    }

    @Test
    void searchValueAtLastNode() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(2, list.search(30));
    }

    @Test
    void searchValueNotPresent() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertEquals(-1, list.search(99));
    }

    @Test
    void searchInEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertEquals(-1, list.search(10));
    }

    @Test
    void searchReturnsFirstOccurrenceOfDuplicate() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(20);
        list.addLast(50);

        assertEquals(1, list.search(20));
    }
    @Test
    void containsValueAtHead() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertTrue(list.contains(10));
    }

    @Test
    void containsValueInMiddle() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertTrue(list.contains(20));
    }

    @Test
    void containsValueAtLastNode() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertTrue(list.contains(30));
    }

    @Test
    void containsValueNotPresent() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertFalse(list.contains(99));
    }

    @Test
    void containsInEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertFalse(list.contains(10));
    }
    @Test
    void clearEmptyList() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void clearPopulatedList() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void clearThenAddElementsAgain() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);

        list.clear();

        list.addFirst(100);
        list.addLast(200);

        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
        assertEquals(100, list.getFirst());
        assertEquals(100, list.get(0));
        assertEquals(200, list.get(1));
    }

    @Test
    void clearMultipleTimes() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast(10);
        list.addLast(20);

        list.clear();
        list.clear();
        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
}