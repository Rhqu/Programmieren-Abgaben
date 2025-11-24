package halloween;

class Vampire extends Creature {
    protected Vampire(String name) {
        super(name, "schwarz");
    }

    @Override
    protected String jumpScare() {
        return super.jumpScare() + "AAAAHHHH!";
    }

    String bite() {
        return "-> Beißt.";
    }
}
