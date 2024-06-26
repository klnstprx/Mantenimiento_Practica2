package org.mps.deque;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {
    DoubleLinkedList<Object> list;

    @Test
    @DisplayName("is instantiated with new DoubleLinkedList()")
    void isInstantiatedWithNew() {
        new DoubleLinkedList<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @Test
        @DisplayName("size is zero")
        void sizeIsZero() {
            list = new DoubleLinkedList<>();
            int expectedValue = 0;
            int obtainedValue = list.size();
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("first is null")
        void firstIsNull() {
            list = new DoubleLinkedList<>();
            Object obtainedValue = list.first();
            assertNull(obtainedValue);
        }

        @Test
        @DisplayName("last is null")
        void lastIsNull() {
            list = new DoubleLinkedList<>();
            Object obtainedValue = list.last();
            assertNull(obtainedValue);
        }

        @Nested
        @DisplayName("after appending an element")
        class AfterAppending {
            static Object item;
            @BeforeAll
            static void setUp() {
                item = new Object();
            }

            @Test
            @DisplayName("size is one")
            void sizeIsOne() {
                list = new DoubleLinkedList<>();
                list.append(item);

                int expectedValue = 1;
                int obtainedValue = list.size();
                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("first is not null")
            void firstIsNotNull() {
                list = new DoubleLinkedList<>();
                list.append(item);

                Object obtainedValue = list.first();
                assertNotNull(obtainedValue);
            }

            @Test
            @DisplayName("last is not null")
            void lastIsNotNull() {
                list = new DoubleLinkedList<>();
                list.append(item);

                Object obtainedValue = list.last();
                assertNotNull(obtainedValue);
            }

            @Nested
            @DisplayName("after deleting first")
            class AfterDeletingFirst {
                @Test
                @DisplayName("size is zero")
                void sizeIsZero() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertEquals(0, list.size());
                }

                @Test
                @DisplayName("first is null")
                void firstIsNull() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    Object obtainedValue = list.first();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("last is null")
                void lastIsNull() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    Object obtainedValue = list.last();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("can't delete last")
                void cannotDeleteLast() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertThrows(DoubleLinkedQueueException.class, () -> list.deleteLast());
                }

                @Test
                @DisplayName("can't delete first")
                void cannotDeleteFirst() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertThrows(DoubleLinkedQueueException.class, () -> list.deleteFirst());
                }
            }

            @Nested
            @DisplayName("after deleting last")
            class AfterDeletingLast {
                @Test
                @DisplayName("size is zero")
                void sizeIsZero() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteLast();

                    int expectedValue = 0;
                    int obtainedValue = list.size();
                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("first is null")
                void firstIsNull() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteLast();

                    Object obtainedValue = list.first();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("last is null")
                void lastIsNull() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteLast();

                    Object obtainedValue = list.last();
                    assertNull(obtainedValue);
                }
            }
        }

        @Nested
        @DisplayName("after prepending an element")
        class AfterPrepending {
            static Object item;
            @BeforeAll
            static void setUp() {
                item = new Object();
            }


            @Test
            @DisplayName("size is one")
            void sizeIsOne() {
                list = new DoubleLinkedList<>();
                list.prepend(item);

                int expectedValue = 1;
                int obtainedValue = list.size();
                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("first is not null")
            void firstIsNotNull() {
                list = new DoubleLinkedList<>();
                list.prepend(item);

                Object expectedValue = item;
                Object obtainedValue = list.first();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("last is not null")
            void lastIsNotNull() {
                list = new DoubleLinkedList<>();
                list.prepend(item);

                Object expectedValue = item;
                Object obtainedValue = list.last();

                assertEquals(expectedValue, obtainedValue);
            }

            @Nested
            @DisplayName("after deleting first")
            class AfterDeletingFirst {
                @Test
                @DisplayName("size is zero")
                void sizeIsZero() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    int expectedValue = 0;
                    int obtainedValue = list.size();
                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("first is null")
                void firstIsNull() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    Object obtainedValue = list.first();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("last is null")
                void lastIsNull() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    Object obtainedValue = list.last();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("can't delete last")
                void cannotDeleteLast() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertThrows(DoubleLinkedQueueException.class, () -> list.deleteLast());
                }

                @Test
                @DisplayName("can't delete first")
                void cannotDeleteFirst() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertThrows(DoubleLinkedQueueException.class, () -> list.deleteFirst());
                }
            }
            @Nested
            @DisplayName("after deleting last")
            class AfterDeletingLast {
                @Test
                @DisplayName("size is zero")
                void sizeIsZero() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteLast();

                    int expectedValue = 0;
                    int obtainedValue = list.size();
                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("first is null")
                void firstIsNull() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteLast();

                    Object obtainedValue = list.first();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("last is null")
                void lastIsNull() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteLast();

                    Object obtainedValue = list.last();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("can't delete last")
                void cannotDeleteLast() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertThrows(DoubleLinkedQueueException.class, () -> list.deleteLast());
                }

                @Test
                @DisplayName("can't delete first")
                void cannotDeleteFirst() {
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertThrows(DoubleLinkedQueueException.class, () -> list.deleteFirst());
                }
            }
        }
    }
    @Test
    @DisplayName("Prepend to a non-empty list")
    void prependToNonEmptyList() {
        list = new DoubleLinkedList<>();
        Object firstItem = new Object();
        Object secondItem = new Object();

        list.prepend(firstItem);
        list.prepend(secondItem);

        assertEquals(2, list.size());
        assertEquals(secondItem, list.first());
        assertEquals(firstItem, list.last());
    }

    @Test
    @DisplayName("Append to a non-empty list")
    void appendToNonEmptyList() {
        list = new DoubleLinkedList<>();
        Object firstItem = new Object();
        Object secondItem = new Object();

        list.append(firstItem);
        list.append(secondItem);

        assertEquals(2, list.size());
        assertEquals(firstItem, list.first());
        assertEquals(secondItem, list.last());
    }

    @Test
    @DisplayName("deleteFirst sets new first's previous to null in a list with multiple elements")
    void deleteFirstOnListWithMultipleElements() {
        list = new DoubleLinkedList<>();
        Object firstItem = new Object();
        Object secondItem = new Object();

        list.append(firstItem);
        list.append(secondItem);

        list.deleteFirst();

        assertEquals(1, list.size());
        assertEquals(secondItem, list.first());
    }

    @Test
    @DisplayName("deleteLast updates last's next to null in a list of multiple elements")
    void deleteLastOnListWithMultipleElements() {
        list = new DoubleLinkedList<>();
        Object firstItem = new Object();
        Object secondItem = new Object();

        list.append(firstItem);
        list.append(secondItem);

        list.deleteLast();

        assertEquals(1, list.size());
        assertEquals(firstItem, list.last());
    }

    @Nested
    @DisplayName("when list has many elements")
    class WhenListHasManyElements {
        DoubleLinkedList<String> list;
        @BeforeEach
        void setUp() {
            list = new DoubleLinkedList<>();
            list.append("First");
            list.append("Second");
            list.append("Third");
            list.append("Another");
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2})
        @DisplayName("getting the n-th element successfully")
        void gettingNthElementSuccessfully(int n) {
            assertDoesNotThrow(() -> {
                Object retrievedItem = list.get(n);
                assertNotNull(retrievedItem, "Retrieved item should not be null.");
            });
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 4})
        @DisplayName("getting element at invalid index throws exception")
        void gettingElementAtInvalidIndexThrowsException(int index) {
            DoubleLinkedQueueException exception = assertThrows(DoubleLinkedQueueException.class, () -> list.get(index),
                    "Expected get(" + index + ") to throw, but it didn't.");
            assertTrue(exception.getMessage().contains("Index out of bounds"), "Exception message should indicate 'Index out of bounds'.");
        }

        @Test
        @DisplayName("Removing from an empty list does nothing")
        void removeFromEmptyList() {
            DoubleLinkedList<String> emptyList = new DoubleLinkedList<>();
            assertDoesNotThrow(() -> emptyList.remove("NotPresent"));
            assertEquals(0, emptyList.size(), "List size should remain 0.");
        }

        @Test
        @DisplayName("Removing the first element from the list")
        void removeFirstElement() {
            list.remove("First");
            assertEquals(3, list.size(), "List size should decrease to 2.");
            assertEquals("Second", list.first(), "First element should now be 'Second'.");
        }

        @Test
        @DisplayName("Removing the last element from the list")
        void removeLastElement() {
            list.remove("Third");
            assertEquals(3, list.size(), "List size should decrease to 2.");
            assertEquals("Another", list.last(), "Last element should now be 'Second'.");
        }

        @Test
        @DisplayName("Removing a middle element from the list")
        void removeMiddleElement() {
            list.remove("Second");
            assertEquals(3, list.size(), "List size should decrease to 2.");
            assertEquals("Third", list.get(1), "Second element should now be 'Third'.");
        }

        @Test
        @DisplayName("Attempting to remove a non-present element does nothing")
        void removeNonPresentElement() {
            list.remove("NonPresent");
            assertEquals(4, list.size(), "List size should remain unchanged.");
        }

        @Test
        @DisplayName("Checking if the list contains an element")
        void containsElement() {
            assertTrue(list.contains("First"), "List should contain 'First'.");
            assertTrue(list.contains("Second"), "List should contain 'Second'.");
            assertTrue(list.contains("Third"), "List should contain 'Third'.");
            assertFalse(list.contains("NotPresent"), "List should not contain 'NotPresent'.");
        }

        @Test
        @DisplayName("Checking if the list contains an element after removing it")
        void containsElementAfterRemoval() {
            list.remove("Second");
            assertFalse(list.contains("Second"), "List should not contain 'Second' after removal.");
        }

        @Test
        @DisplayName("Sorting the list")
        void sortList() {
            Comparator<String> comparator = Comparator.naturalOrder();
            list.sort(comparator);
            assertEquals("Another", list.get(0), "First element should be 'Another'.");
            assertEquals("First", list.get(1), "Second element should be 'First'.");
            assertEquals("Second", list.get(2), "Third element should be 'Second'.");
            assertEquals("Third", list.get(3), "Fourth element should be 'Third'.");
        }
    }

    @Test
    @DisplayName("Removing the only element sets first and last to null")
    void removeOnlyElement() {
        DoubleLinkedList<String> singleElementList = new DoubleLinkedList<>();
        singleElementList.append("OnlyElement");

        singleElementList.remove("OnlyElement");

        assertNull(singleElementList.first(), "First should be null after removing the only element.");
        assertNull(singleElementList.last(), "Last should be null after removing the only element.");
        assertEquals(0, singleElementList.size(), "List size should be 0.");
    }

    @Test
    @DisplayName("Sort the only element does nothing")
    void sortOnlyElement() {
        DoubleLinkedList<String> singleElementList = new DoubleLinkedList<>();
        singleElementList.append("OnlyElement");

        singleElementList.sort(Comparator.naturalOrder());

        assertEquals("OnlyElement", singleElementList.first(), "First should be OnlyElement.");
        assertEquals("OnlyElement", singleElementList.last(), "Last should be OnlyElement.");
        assertEquals(1, singleElementList.size(), "List size should be 1.");
    }
}
