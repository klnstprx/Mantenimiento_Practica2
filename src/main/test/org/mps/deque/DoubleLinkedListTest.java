package org.mps.deque;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {
    DoubleLinkedList<Object> list;
    Object item;

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

            @Test
            @DisplayName("size is one")
            void sizeIsOne() {
                item = new Object();
                list = new DoubleLinkedList<>();
                list.append(item);

                int expectedValue = 1;
                int obtainedValue = list.size();
                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("first is not null")
            void firstIsNotNull() {
                item = new Object();
                list = new DoubleLinkedList<>();
                list.append(item);

                Object obtainedValue = list.first();
                assertNotNull(obtainedValue);
            }

            @Test
            @DisplayName("last is not null")
            void lastIsNotNull() {
                item = new Object();
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
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertEquals(0, list.size());
                }

                @Test
                @DisplayName("first is null")
                void firstIsNull() {
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    Object obtainedValue = list.first();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("last is null")
                void lastIsNull() {
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    Object obtainedValue = list.last();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("can't delete last")
                void canNotDeleteLast() {
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertThrows(DoubleLinkedQueueException.class, () -> list.deleteLast());
                }

                @Test
                @DisplayName("can't delete first")
                void canNotDeleteFirst() {
                    item = new Object();
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
                    item = new Object();
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
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteLast();

                    Object obtainedValue = list.first();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("last is null")
                void lastIsNull() {
                    item = new Object();
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

            @Test
            @DisplayName("size is one")
            void sizeIsOne() {
                item = new Object();
                list = new DoubleLinkedList<>();
                list.prepend(item);

                int expectedValue = 1;
                int obtainedValue = list.size();
                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("first is not null")
            void firstIsNotNull() {
                item = new Object();
                list = new DoubleLinkedList<>();
                list.prepend(item);

                Object expectedValue = item;
                Object obtainedValue = list.first();

                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("last is not null")
            void lastIsNotNull() {
                item = new Object();
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
                    item = new Object();
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
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    Object obtainedValue = list.first();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("last is null")
                void lastIsNull() {
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    Object obtainedValue = list.last();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("can't delete last")
                void cannotDeleteLast() {
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertThrows(DoubleLinkedQueueException.class, () -> list.deleteLast());
                }

                @Test
                @DisplayName("can't delete first")
                void cannotDeleteFirst() {
                    item = new Object();
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
                    item = new Object();
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
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteLast();

                    Object obtainedValue = list.first();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("last is null")
                void lastIsNull() {
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteLast();

                    Object obtainedValue = list.last();
                    assertNull(obtainedValue);
                }

                @Test
                @DisplayName("can't delete last")
                void cannotDeleteLast() {
                    item = new Object();
                    list = new DoubleLinkedList<>();
                    list.append(item);
                    list.deleteFirst();

                    assertThrows(DoubleLinkedQueueException.class, () -> list.deleteLast());
                }

                @Test
                @DisplayName("can't delete first")
                void cannotDeleteFirst() {
                    item = new Object();
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
}
