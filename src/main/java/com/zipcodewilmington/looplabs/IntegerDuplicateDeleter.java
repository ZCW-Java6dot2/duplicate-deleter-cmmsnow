package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    //Integer[] intArray = new Integer[]{};//should I be adding this?

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    public Integer[] countRepeats(){
        if (array == null) throw new NullPointerException("Null: add to intArray before this");
        Integer[] numOfDupes = new Integer[array.length];
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length; j++){
                int counter = 0;
                if (i != j){
                    if (array[i] == array[j]){
                        counter++;
                    }
                }
                numOfDupes[i] = counter;
            }
        }
        return numOfDupes;
    }


    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        //count how many indexes to delete
        int indexNumToDelete = 0;
        Integer[] numOfDupes = countRepeats();
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] >= maxNumberOfDuplications){
                indexNumToDelete++;
            }
        }
        //create new array
        Integer[] answer = new Integer[array.length-indexNumToDelete];
        //add all (non deleted) indexes
        if (answer.length == 0) return answer;
        int j=0;
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] < maxNumberOfDuplications){
                answer[j] = array[i];
                j++;
            }
        }
        return answer;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        //count how many indexes to delete
        int indexNumToDelete = 0;
        Integer[] numOfDupes = countRepeats();
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] == exactNumberOfDuplications){
                indexNumToDelete++;
            }
        }
        //create new array
        Integer[] answer = new Integer[array.length-indexNumToDelete];
        //add all (non deleted) indexes
        int j=0;
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] != exactNumberOfDuplications){
                answer[j] = array[i];
                j++;
            }
        }
        return answer;
    }
}

//    @Override
//    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
//        return Arrays.stream(array).filter(y -> getOccurrence(y) < maxNumberOfDuplications).toArray(Integer[] :: new);
//    }
//    public Long getOccurrence(int x){
//        return Arrays.stream(array).filter(z -> z==x).count();
//    }
//
//    @Override
//    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
//        return Arrays.stream(array).filter(y -> getOccurrence(y) != exactNumberOfDuplications).toArray(Integer[]::new);
//    }