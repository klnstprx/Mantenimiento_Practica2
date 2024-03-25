package org.mps.deque;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedNodeTest {

    LinkedNode<Object> linkedNode;
    Object item;

    @BeforeEach
    public void setup() {
        item = new Object();
        linkedNode = new LinkedNode<Object>(item, null, null);
    }

    @Nested
    @DisplayName("A LinkedNode")
    class TestingLinkedNode {

        @Test
        @DisplayName("If you change the item of a LinkedNode, the item should be changed.")
        public void itemChanged() {
            linkedNode.setItem(1);

            Object expectedValue = 1;
            Object obtainedValue = linkedNode.getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("If you change the previous of a LinkedNode, the previous should be changed.")
        public void previousLinkedNodeChanged() {
            Object previousItem = new Object();
            LinkedNode<Object> previous = new LinkedNode<>(previousItem, null, null);
            linkedNode.setPrevious(previous);

            LinkedNode<Object> expectedValue = previous;
            LinkedNode<Object> obtainedValue = linkedNode.getPrevious();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("If you change the next of a LinkedNode, the next should be changed.")
        public void nextlinkedNodeChanged() {
            Object nextItem = new Object();
            LinkedNode<Object> next = new LinkedNode<>(nextItem, null, null);
            linkedNode.setNext(next);

            LinkedNode<Object> expectedValue = next;
            LinkedNode<Object> obtainedValue = linkedNode.getNext();

            assertEquals(expectedValue, obtainedValue);
        }

        @Nested
        @DisplayName("when in a chain of LinkedNodes")
        class WhenInChain {

            @Nested
            @DisplayName("The first node")
            class theFirstNode {

                @Test
                @DisplayName("If a LinkedNode is the first node, the method isFirstNode should return true.")
                public void itIsTheFirstNode() {
                    LinkedNode<Object> linkedNode1 = new LinkedNode<Object>(item, null, null);
                    LinkedNode<Object> linkedNode2 = new LinkedNode<Object>(item, linkedNode1, null);
                    linkedNode1.setNext(linkedNode2);

                    boolean obtainedValue = linkedNode1.isFirstNode();

                    assertTrue(obtainedValue);
                }

                @Test
                @DisplayName("If a LinkedNode is not the first node, the method isFirstNode should return false.")
                public void itIsNotTheFirstNode() {
                    LinkedNode<Object> linkedNode1 = new LinkedNode<Object>(item, null, null);
                    LinkedNode<Object> linkedNode2 = new LinkedNode<Object>(item, linkedNode1, null);
                    linkedNode1.setNext(linkedNode2);

                    boolean obtainedValue = linkedNode2.isFirstNode();

                    assertFalse(obtainedValue);
                }
            }

            @Nested
            @DisplayName("The last node")
            class theLastNode {

                @Test
                @DisplayName("If a LinkedNode is the first node, the method isFirstNode should return true.")
                public void itIsTheFirstNode() {
                    LinkedNode<Object> linkedNode1 = new LinkedNode<Object>(item, null, null);
                    LinkedNode<Object> linkedNode2 = new LinkedNode<Object>(item, linkedNode1, null);
                    linkedNode1.setNext(linkedNode2);

                    boolean obtainedValue = linkedNode1.isFirstNode();

                    assertTrue(obtainedValue);
                }

                @Test
                @DisplayName("If a LinkedNode is not the first node, the method isFirstNode should return false.")
                public void itIsNotTheFirstNode() {
                    LinkedNode<Object> linkedNode1 = new LinkedNode<Object>(item, null, null);
                    LinkedNode<Object> linkedNode2 = new LinkedNode<Object>(item, linkedNode1, null);
                    linkedNode1.setNext(linkedNode2);

                    boolean obtainedValue = linkedNode2.isFirstNode();

                    assertFalse(obtainedValue);
                }
            }

            @Nested
            @DisplayName("Not a terminal node")
            class notATerminalNode {

                @Test
                @DisplayName("If a LinkedNode is not the first or last node, the method isNotATerminalNode should return true.")
                public void isNotATerminalNode() {
                    LinkedNode<Object> linkedNode1 = new LinkedNode<Object>(item, null, null);
                    LinkedNode<Object> linkedNode2 = new LinkedNode<Object>(item, linkedNode1, null);
                    LinkedNode<Object> linkedNode3 = new LinkedNode<Object>(item, linkedNode2, null);
                    linkedNode1.setNext(linkedNode2);
                    linkedNode2.setNext(linkedNode3);

                    boolean obtainedValue = linkedNode2.isNotATerminalNode();

                    assertTrue(obtainedValue);
                }

                @Test
                @DisplayName("If a LinkedNode is the first node, the method isNotATerminalNode should return false.")
                public void isTheFirstTerminalNode() {
                    LinkedNode<Object> linkedNode1 = new LinkedNode<Object>(item, null, null);
                    LinkedNode<Object> linkedNode2 = new LinkedNode<Object>(item, linkedNode1, null);
                    linkedNode1.setNext(linkedNode2);

                    boolean obtainedValue = linkedNode1.isNotATerminalNode();

                    assertFalse(obtainedValue);
                }

                @Test
                @DisplayName("If a LinkedNode is the last node, the method isNotATerminalNode should return false.")
                public void isTheLastTerminalNode() {
                    LinkedNode<Object> linkedNode1 = new LinkedNode<Object>(item, null, null);
                    LinkedNode<Object> linkedNode2 = new LinkedNode<Object>(item, linkedNode1, null);
                    linkedNode1.setNext(linkedNode2);

                    boolean obtainedValue = linkedNode2.isNotATerminalNode();

                    assertFalse(obtainedValue);
                }
            }
        }
    }
}

