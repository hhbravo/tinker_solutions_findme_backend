package com.tinker.factory.findme.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by josediaz on 6/01/2017.
 */
public interface MaintenanceService<F, R, M, N, ID extends Serializable> {

    List<R> search(F filterViewModel);
    M findOne(ID id);
    N create(M manteinanceViewModel);
    N update(M manteinanceViewModel);
    N delete(ID id);
}
