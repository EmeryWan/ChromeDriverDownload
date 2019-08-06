package pers.emery.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author emery
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChromeInfoVO {

    private String chromeVersion;

    private String driverVersion;

}
