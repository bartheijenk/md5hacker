package nl.belastingdienst.force.generator;

import nl.belastingdienst.force.generator.CharacterSupplier;
import nl.belastingdienst.force.util.CharCollector;

import java.util.LinkedList;

public class SplitPasswordGenerator implements PasswordGenerator {
    private final LinkedList<CharacterSupplier> characterSuppliers = new LinkedList<>();

    public SplitPasswordGenerator() {
        characterSuppliers.add(new CharacterSupplier());
    }

    public String getPassword() {
        String password = characterSuppliers.stream()
                .map(CharacterSupplier::peek)
                .collect(new CharCollector());

        if(!incrementSuppliers()) {
            addCharacter();
        }

        return password;
    }

    private boolean incrementSuppliers() {
        for (CharacterSupplier currentSupplier : characterSuppliers) {
            if (currentSupplier.hasNext()) {
                currentSupplier.next();
                return true;
            } else {
                currentSupplier.reset();
            }
        }
        return false;
    }

    private void addCharacter() {
        characterSuppliers.add(new CharacterSupplier());
        for(CharacterSupplier characterSupplier : characterSuppliers) {
            characterSupplier.reset();
        }
    }
}
//ff