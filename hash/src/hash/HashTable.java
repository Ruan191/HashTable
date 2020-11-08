/*
 * The MIT License
 *
 * Copyright 2020 Ruan191.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 *
 * @author Ruan191
 */
package hash;

public class HashTable {
       
    private String[][] hashArray;
    
    public HashTable(){
        hashArray = new String[1000][100];
    }
    
    public HashTable(int hashArraySize, int hashStackArraySize){
        hashArray = new String[hashArraySize][hashStackArraySize];
    }

    public int hashKey(String text){
        int value = 0;
        
        for (int i = 0; i < text.length(); i++){
            value += ((int)text.toLowerCase().toCharArray()[i] - 97);
        }
        
        return value;
    }
    
    //loads the Strings into the indexes and stacks (if needed)
    public void hashMap(String text, int index){
        int indexAppend = 0;

        if (hashArray[index] != null){
            while(hashArray[index][indexAppend] != null){
                indexAppend++;
            }
        }

        hashArray[index][indexAppend] = text;
        System.out.println(text + " at index " + (index) + " on stack " + indexAppend);
    }
    
    //Looks for the String in the index and stacks
    public boolean hashStringValueExist(String text){
        int indexAppend = 0;
        
        if (!text.equals(hashArray[hashKey(text)][0])){
            while(hashArray[hashKey(text)][indexAppend] != null && indexAppend != 101){
                if (hashArray[hashKey(text)][indexAppend].equals(text)){
                    return true;                  
                }else{
                    indexAppend++;
                }
              
            }
        }else{
            return true;
        }
        return false;
    }
}
