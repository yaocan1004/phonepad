package com.antra.phonepad.combination.dto.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class NumberRequest {
    @NotBlank
    @Size(min=3,max=3)
    private String first;

    @NotBlank
    @Size(min=3,max=3)
    private String second;

    @NotBlank
    @Size(min=4,max=4)
    private String third;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberRequest)) return false;
        NumberRequest that = (NumberRequest) o;
        return Objects.equals(getFirst(), that.getFirst()) &&
                Objects.equals(getSecond(), that.getSecond()) &&
                Objects.equals(getThird(), that.getThird());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirst(), getSecond(), getThird());
    }

    @Override
    public String toString() {
        return first+"-"+second+"-"+third;
    }
}
