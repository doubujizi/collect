package com.dou.tfx.prefect.enity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * @author tianfuxian
 * @Description:
 * @Date: 2020/11/11 15:10
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNoEquals {
    private String phone;
    private String name;
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNoEquals that = (PhoneNoEquals) o;
        return Objects.equals(phone, that.phone) &&
                Objects.equals(name, that.name) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, name, id);
    }
}
