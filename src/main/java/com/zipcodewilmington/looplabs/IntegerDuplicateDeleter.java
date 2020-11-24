package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    Integer[] intArray = new Integer[]{};//should I be adding this?

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    public Integer[] countRepeats(){
        if (intArray == null) throw new NullPointerException("Null: add to intArray before this");
        Integer[] numOfDupes = new Integer[intArray.length];
        for (int i=0; i<intArray.length; i++){
            for (int j=0; j<intArray.length; j++){
                int counter = 0;
                if (i != j){
                    if (intArray[i] == intArray[j]){
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
        Integer[] answer = new Integer[intArray.length-indexNumToDelete];
        //add all (non deleted) indexes
        if (answer.length == 0) return answer;
        int j=0;
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] < maxNumberOfDuplications){
                answer[j] = intArray[i];
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
        Integer[] answer = new Integer[intArray.length-indexNumToDelete];
        //add all (non deleted) indexes
        int j=0;
        for (int i=0; i<numOfDupes.length; i++){
            if (numOfDupes[i] != exactNumberOfDuplications){
                answer[j] = intArray[i];
                j++;
            }
        }
        return answer;
    }
}
