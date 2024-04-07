package org.testtask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BidirectionalMapTest {
    private BidirectionalMap<String, Integer> bidirectionalMap;

    @BeforeEach
    public void setUp() {
        bidirectionalMap = new SimpleBidirectionalMap<>();
    }

    @Test
    @DisplayName("Put should add key-value pair to the map")
    public void givenEmptyBidirectionalMap_whenPut_thenReturnsCorrespondingValue() {
        // given

        // when
        bidirectionalMap.put("One", 1);

        // then
        assertEquals(1, bidirectionalMap.get("One"));
    }

    @Test
    @DisplayName("GetKey should return key for a given value")
    public void givenMapWithEntry_whenGetKey_thenReturnsCorrespondingKey() {
        // given
        bidirectionalMap.put("One", 1);

        // when
        String key = bidirectionalMap.getKey(1);

        // then
        assertEquals("One", key);
    }

    @Test
    @DisplayName("ContainsKey should return true for existing key")
    public void givenMapWithEntry_whenContainsExistingKey_thenReturnsTrue() {
        // given
        bidirectionalMap.put("One", 1);

        // then
        assertTrue(bidirectionalMap.containsKey("One"));
    }

    @Test
    @DisplayName("ContainsKey should return false for non-existing key")
    public void givenMapWithEntry_whenContainsNonExistingKey_thenReturnsFalse() {
        // given
        bidirectionalMap.put("One", 1);

        // then
        assertFalse(bidirectionalMap.containsKey("Two"));
    }

    @Test
    @DisplayName("ContainsValue method should return true for existing value")
    public void givenMapWithEntry_whenContainsExistingValue_thenReturnsTrue() {
        // given
        bidirectionalMap.put("One", 1);

        // then
        assertTrue(bidirectionalMap.containsValue(1));
    }

    @Test
    @DisplayName("containsValue method should return false for non-existing value")
    public void givenMapWithEntry_whenContainsNonExistingValue_thenReturnsFalse() {
        // given
        bidirectionalMap.put("One", 1);

        // then
        assertFalse(bidirectionalMap.containsValue(2));
    }

    @Test
    @DisplayName("size method should return the number of elements in the map")
    public void givenMapWithTwoEntries_whenSize_thenReturnsTwo() {
        // given
        bidirectionalMap.put("One", 1);
        bidirectionalMap.put("Two", 2);

        // then
        assertEquals(2, bidirectionalMap.size());
    }

    @Test
    @DisplayName("size method should return the number of elements in the map")
    public void givenMapWithZeroEntries_whenSize_thenReturnsZero() {
        // given

        // then
        assertEquals(0, bidirectionalMap.size());
    }
}