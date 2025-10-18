# -*- coding: utf-8 -*-
import pytest
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
import os

@pytest.fixture
def setup():
    options = Options()
    options.add_argument("--start-maximized")  # Lancer Chrome plein écran
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)
    yield driver
    driver.quit()


# --- Capture d’écran automatique en cas d’échec ---
@pytest.hookimpl(hookwrapper=True)
def pytest_runtest_makereport(item):
    outcome = yield
    rep = outcome.get_result()

    if rep.when == "call" and rep.failed:
        driver = item.funcargs.get("setup")
        if driver:
            screenshots_dir = os.path.join(os.path.dirname(__file__), "../screenshots")
            os.makedirs(screenshots_dir, exist_ok=True)

            file_name = f"{item.name}.png"
            screenshot_path = os.path.join(screenshots_dir, file_name)

            driver.save_screenshot(screenshot_path)
            print(f"\n📸 Capture d’écran enregistrée : {screenshot_path}")
