package chapter_1_stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_04_DogCatQueue {

    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetQueueItem {
        private Pet pet;
        private int index;

        public PetQueueItem(Pet pet, int index) {
            this.pet = pet;
            this.index = index;
        }
    }

    public static class DogCatQueue {
        private Queue<PetQueueItem> dogQueue;
        private Queue<PetQueueItem> catQueue;
        private int size;

        public DogCatQueue() {
            this.dogQueue = new LinkedList<PetQueueItem>();
            this.catQueue = new LinkedList<PetQueueItem>();
            this.size = 0;
        }

        public void add(Pet pet) {
            this.size++;
            if (pet.getType() == "dog") {
                this.dogQueue.add(new PetQueueItem(pet, this.size));
            } else if (pet.getType() == "cat") {
                this.catQueue.add(new PetQueueItem(pet, this.size));
            } else {
                throw new RuntimeException("unknow pet type");
            }
        }

        public void pollAll() {
            while (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
                Pet pet = null;
                if (this.dogQueue.peek().index < this.catQueue.peek().index) {
                    pet = this.dogQueue.poll().pet;
                } else {
                    pet = this.catQueue.poll().pet;
                }

                System.out.println(pet.getType());
            }

            while (!this.dogQueue.isEmpty()) {
                System.out.println(this.dogQueue.poll().pet.getType());
            }

            while (!this.catQueue.isEmpty()) {
                System.out.println(this.catQueue.poll().pet.getType());
            }
        }

        public void pollCat() {
            while (!this.catQueue.isEmpty()) {
                System.out.println(this.catQueue.poll().pet.getType());
            }
        }

        public void pollDog() {
            while (!this.dogQueue.isEmpty()) {
                System.out.println(this.dogQueue.poll().pet.getType());
            }
        }

        public boolean isEmpty() {
            return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
        }

        public boolean isDogEmpty() {
            return this.dogQueue.isEmpty();
        }

        public boolean isCatEmpty() {
            return this.catQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        DogCatQueue queue = new DogCatQueue();
        queue.add(new Dog());
        queue.add(new Dog());
        queue.add(new Cat());

        queue.pollAll();

        queue.add(new Cat());
        queue.add(new Dog());
        queue.add(new Dog());
        queue.pollCat();
        queue.pollDog();
    }

}
