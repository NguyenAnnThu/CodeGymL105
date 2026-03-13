package com.example.databinding1.service;

import com.example.databinding1.entity.Settings;

public interface ISettingsService {

    Settings getSettings();

    void updateSettings(Settings settings);
}
