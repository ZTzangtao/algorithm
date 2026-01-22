package programmer_code_interview_guide.stack_and_queue;

import java.util.*;
import java.io.*;




// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class CatAndDogQueue {

    public static void main(String[] args) throws IOException {
        DogCatQueue dogCatQueue = new DogCatQueue();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String str = bufferedReader.readLine();
            if ("isEmpty".equals(str)) {
                System.out.println(dogCatQueue.isEmpty() ? "yes" : "no");
            } else if ("pollAll".equals(str)) {
                while (!dogCatQueue.isEmpty()) {
                    Pet pet = dogCatQueue.pollAll();
                    System.out.println(pet.getPetType() + " " + pet.getPetNumber());
                }
            } else if ("pollDog".equals(str)) {
                while (!dogCatQueue.isDogQueueEmpty()) {
                    Pet dog = dogCatQueue.pollDog();
                    System.out.println(dog.getPetType() + " " + dog.getPetNumber());
                }
            } else if ("pollCat".equals(str)) {
                while (!dogCatQueue.isCatQueueEmpty()) {
                    Pet cat = dogCatQueue.pollCat();
                    System.out.println(cat.getPetType() + " " + cat.getPetNumber());
                }

            } else if ("isDogEmpty".equals(str)) {
                System.out.println(dogCatQueue.isDogQueueEmpty() ? "yes" : "no");
            } else if ("isCatEmpty".equals(str)) {
                System.out.println(dogCatQueue.isCatQueueEmpty() ? "yes" : "no");
            } else if (str.startsWith("add")) {
                String[] strArr = str.split(" ");
                dogCatQueue.add(new Pet(strArr[1], Integer.parseInt(strArr[2])));
            }
        }
        bufferedReader.close();
    }
}



class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add (Pet pet) {
        if ("dog".equals(pet.getPetType())) {
            this.dogQ.add(new PetEnterQueue(pet,  this.count++));
        } else if ("cat".equals(pet.getPetType())) {
            this.catQ.add(new PetEnterQueue(pet,  this.count++));
        } else {
            throw new RuntimeException("err, not dog or cat");
        }
    }

    public Pet pollAll () {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("err,queue is empty");
        }
    }

    public Pet pollDog() {
        if (!this.isDogQueueEmpty()) {
            return  this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty");
        }
    }

    public Pet pollCat() {
        if (!this.isCatQueueEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("cat queue is empty");
        }
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }

}


class Pet {
    private String type;
    private Integer number;
    public Pet (String type, Integer number) {
        this.type = type;
        this.number = number;
    }
    public String getPetType () {
        return this.type;
    }

    public Integer getPetNumber () {
        return this.number;
    }
}

class Dog extends Pet {
    public Dog() {
        super("dog", 0);
    }

}

class Cat extends Pet {
    public Cat() {
        super("cat", 0);
    }
}

class PetEnterQueue {
    private Pet pet;

    private long count;

    public PetEnterQueue (Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }
    public long getCount() {
        return this.count;
    }
    public String getEnterPetType() {
        return this.pet.getPetType();
    }

    public Integer getEnterPetNumber() {
        return this.pet.getPetNumber();
    }
}

