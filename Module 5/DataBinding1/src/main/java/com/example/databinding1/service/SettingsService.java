package com.example.databinding1.service;

import com.example.databinding1.entity.Settings;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements ISettingsService {
    private Settings settings = new Settings(
            "English",
            10,
            true,
            "Best regards"
    );

    @Override
    public Settings getSettings() {
        return settings;
    }

    @Override
    public void updateSettings(Settings settings) {
        this.settings = settings;
    }
}
