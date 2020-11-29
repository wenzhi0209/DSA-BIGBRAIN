package client;

import adt.ArrayList;
import entity.Animal;

public class AnimalList {

    static ArrayList<Animal> animalList = new ArrayList<Animal>();

    public AnimalList() {
        animalList.add(new Animal("Nothing", 0, 0, "N/A", "Please try harder next time"));
        animalList.add(new Animal("Raccoon", 5, 3, "Jimin", "Researchers at the USDA National Wildlife Center and the University of Wyoming gave raccoons a pitcher of water containing marshmallows and some pebbles.\nIn order to reach the marshmallows, the raccoons had to raise the water level. Half of the raccoons figured out how to use pebbles to get the treat.\nAnother simply found a way to knock over the pitcher. Raccoons are also notoriously good at picking locks and can remember solutions to problems for three years."));
        animalList.add(new Animal("Dog", 10, 3, "Rose", "Man's best friend uses its intelligence to relate to humans. Dogs understand emotions, show empathy, and understand symbolic language.\nAccording to canine intelligence expert Stanley Coren, the average dog understand around 165 human words.\nHowever, they can learn many more. A border collie named Chaser demonstrated understanding of 1022 words.\nAn analysis of his vocabulary was published in the February 2011 issue of the Behavioural Processes Journal."));
        animalList.add(new Animal("Parrot", 20, 2, "Panda", "Parrots are thought to be as smart as a human child. These birds solve puzzles and also understand the concept of cause and effect.\nThe Einstein of the parrot world is the African Grey, a bird known for its astounding memory and ability to count.\nAfrican Grey parrots can learn an impressive number of human words and use them in context to communicate with people."));
        animalList.add(new Animal("Octopus", 30, 4, "Bubu", "While we're most familiar with intelligence in other vertebrates, some invertebrates are incredibly clever.\nThe octopus has the largest brain of any invertebrate, yet three-fifths of its neurons are actually in its arms.\nThe octopus is the only invertebrate that uses tools.\nAn octopus named Otto was known to throw rocks and spray water at the bright overhead lights of his aquarium in order to short them out."));
        animalList.add(new Animal("Pig", 40, 5, "Doja Cat", "Pigs solve mazes, understand and display emotions, and understand symbolic language. Piglets grasp the concept of reflection at a younger age than humans.\nSix-week-old piglets that see food in a mirror can work out where the food is located.\nIn contrast, it takes human babies several months to understand reflection.\nPigs also understand abstract representations and can apply this skill to play video games using a joystick."));
        animalList.add(new Animal("Dolphin", 50, 4, "RM", "Dolphins and whales are at least as smart as birds and primates. A dolphin has a large brain relative to its body size.\nThe cortex of a human brain is highly convoluted, but a dolphin brain has even more folds!\nDolphins and their kin are the only marine animals that have passed the mirror test of self-awareness."));
        animalList.add(new Animal("Gorilla", 60, 3, "Grizz", "The gorilla named Koko became famous for learning sign language and caring for a pet cat.\nGorillas can form original sentences to communicate with humans and understand the use of symbols to represent objects and more complex concepts."));
        animalList.add(new Animal("Elephant", 70, 2, "Ice Bear", "Elephants have the largest brains of any land animal. The cortex of an elephant's brain has as many neurons as a human brain.\nElephants have exceptional memories, cooperate with each other, and demonstrate self-awareness.\nLike primates and birds, they engage in play."));
        animalList.add(new Animal("Chimpanzee", 80, 1, "Ice Bear", "Chimps are our closest relatives in the animal kingdom, so it's unsurprising they display intelligence similar to that of humans.\nChimps fashion spears and other tools, display a wide range of emotions, and recognize themselves in a mirror.\nChimps can learn sign language to communicate with humans."));
        animalList.add(new Animal("Ravens and Crows", 100, 0, "N/A", "The entire Corvid family of birds is clever. The group includes magpies, jays, ravens, and crows.\nThese birds are the only non-primate vertebrates that invent their own tools.\n Crows recognize human faces, communicate complex concepts with other crows, and think about the future.\nMany experts compare crow intelligence to that of a 7-year-old human child."));
    }

    public int getAnimalIq(int i) {
        return animalList.getEntry(i + 1).getIq();
    }

    public String displayResultAt(int i) {
        String str = "";
        str = (animalList.getEntry(i + 1).toString());
        return str;
    }

    public String showAnimal(int score) {
        String str = "";
        for (int i = 1; i < animalList.getLength(); i++) {
            if (score >= animalList.getEntry(i).getIq()) {
                str = animalList.getEntry(i).toString();
            }
        }
        return str;
    }

    public int animalIndex(int score) {
        int index = 0;
        
        if (score < 5) { 
            index = 1;
        } else if (score < 10) {
            index = 2;
        } else if (score < 20) { 
            index = 3;
        } else if (score < 30) {
            index = 4;
        } else if (score < 40) {
            index = 5;
        } else if (score < 50) {
            index = 6;
        } else if (score < 60) {
            index = 7;
        } else if (score < 70) {
            index = 8;
        } else if (score < 80) {
            index = 9;
        } else if (score < 100) {
            index = 10;
        } else if (score >= 100) {
            index = 11;
        }
        return index;
    }

}
