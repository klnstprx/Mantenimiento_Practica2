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
        }
    }

}
