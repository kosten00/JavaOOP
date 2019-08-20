package ru.academits.vasilev.list;

class ListItem<T> {
    private T data;
    private ListItem<T> next;

    public ListItem(T data) {
        this.data = data;
    }

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }
}

class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;
}
