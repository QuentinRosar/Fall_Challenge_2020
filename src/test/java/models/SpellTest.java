package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SpellTest {
    @Test
    public void testSetCastable() {
        Spell spell = new Spell();
        spell.setCastable(true);
        assertTrue(spell.isCastable());
    }

    @Test
    public void testSetTomIndex() {
        Spell spell = new Spell();
        spell.setTomIndex(1);
        assertEquals(1, spell.getTomIndex());
    }

    @Test
    public void testSetTaxCount() {
        Spell spell = new Spell();
        spell.setTaxCount(3);
        assertEquals(3, spell.getTaxCount());
    }

    @Test
    public void testSetRepeatable() {
        Spell spell = new Spell();
        spell.setRepeatable(true);
        assertTrue(spell.isRepeatable());
    }

    @Test
    public void testToString() {
        assertEquals("Spell{castable=false}", (new Spell()).toString());
    }
}

