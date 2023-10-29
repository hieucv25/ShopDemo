package com.example.demo.ViewModel;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class HistoryList {
    public List<HistoryBuy> listHistory;

}
