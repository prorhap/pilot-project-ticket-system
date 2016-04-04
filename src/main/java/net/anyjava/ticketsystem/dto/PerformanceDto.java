package net.anyjava.ticketsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.anyjava.ticketsystem.domain.Performance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anyjava on 2016. 4. 5..
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PerformanceDto {

    private long totalCount;

    private List<Performance> performances = new ArrayList<>();

}
