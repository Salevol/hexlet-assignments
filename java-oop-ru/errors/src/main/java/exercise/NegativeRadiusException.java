package exercise;

class NegativeRadiusException extends Exception{
    NegativeRadiusException(){}
    NegativeRadiusException(String str) {
        System.out.println(str);
    }
}
