package test.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter // setter
@Getter // getter
@AllArgsConstructor // 모든 인자를 받는 생성자
@NoArgsConstructor // 기본생성자
public class DataVO {
    private String msg;
}
