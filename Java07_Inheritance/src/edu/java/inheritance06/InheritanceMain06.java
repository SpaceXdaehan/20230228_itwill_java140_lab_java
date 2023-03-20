package edu.java.inheritance06;

class T {
    @Override // java.lang.Object 클래스에서 상속한 toString 메서드를 override.
    public String toString() {
        // 객체를 문자열로(to String) 변환해서 리턴.
        return "T 타입 인스턴스";
    }
}

public class InheritanceMain06 {

    public static void main(String[] args) {
        // java.lang.Object 클래스: 자바의 최상위 클래스.
        // 자바의 모든 클래스는 Object의 protected 또는 public 멤버(메서드)를 상속받아서
        // 사용 가능하고, 재정의(override)할 수 있음.
        // Object 클래스의 메서드 재정의: toString, equals, hashCode, ...
        
        // System.out.println(Object x):
        // argument로 전달된 객체의 toString() 메서드가 리턴하는 문자열을 콘솔창에 출력.
        // 클래스를 정의할 때, toString() 메서드를 override해서 원하는 문자열이 출력될 수 있도록 할 수 있음.
        T t = new T();
        System.out.println(t);
        
    }

}
