package models;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestSpell {

    @Test
    public void createSpell() {
        Spell spell = new Spell(true);
        Assertions.assertEquals(true, spell.isCastable());
        spell.setCastable(false);
        Assertions.assertEquals(false, spell.isCastable());
    }
}
