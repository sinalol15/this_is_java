package ch12.sec03.exam04;

public record Member(String id, String name, int age) { // 생성자, get-set, toString, hashCode, equals 함수 다 포함되어있음.
// record - ver14 이상에서만 사용가능
}