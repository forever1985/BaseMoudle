package com.company.base_library.base.viewmodel;


import androidx.annotation.NonNull;

import com.company.base_library.base.viewmodel.BaseViewModel;

/**
 * ItemViewModel
 * Created by goldze on 2018/10/3.
 */

public class ItemViewModel<VM extends BaseViewModel> {
    protected VM viewModel;

    public ItemViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }
}
