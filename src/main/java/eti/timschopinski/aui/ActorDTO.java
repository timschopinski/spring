package eti.timschopinski.aui;

public class ActorDTO {
    private String name;
    private int age;

    public ActorDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Actor: " + name + " (Age: " + age + ")";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int age;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public ActorDTO build() {
            return new ActorDTO(name, age);
        }
    }
}
