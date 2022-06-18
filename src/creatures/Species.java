package creatures;

public enum Species {
  CAT {
    public String toString() {
      return "Cat";
    }
  },
  DOG {
    public String toString() {
      return "Dog";
    }
  }
}
