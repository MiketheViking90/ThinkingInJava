package containers.exercises;

import lombok.Getter;

class Link<T> {
    @Getter T data;
    @Getter Link<T> next;

    public Link(T t) {
        data = t;
        next = null;
    }
}
