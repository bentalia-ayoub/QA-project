# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.firefox.service import Service
from selenium.webdriver.common.by import By
import os
import time

# --- Chemin vers geckodriver ---
driver_path = os.path.join(os.path.dirname(os.path.dirname(__file__)), "drivers", "geckodriver")
service = Service(driver_path)

# --- Lancer Firefox ---
driver = webdriver.Firefox(service=service)
driver.get("https://formy-project.herokuapp.com/form")
driver.maximize_window()

try:
    driver.find_element(By.ID, "first-name").send_keys("Ayoub")
    driver.find_element(By.ID, "last-name").send_keys("Bentalia")
    driver.find_element(By.ID, "job-title").send_keys("QA Engineer")
    
    driver.find_element(By.CSS_SELECTOR, ".btn.btn-lg.btn-primary").click()
    time.sleep(2)
    
    print("✅ Test réussi : le formulaire a été soumis avec succès")
except Exception as e:
    print("❌ Erreur :", e)
finally:
    driver.quit()

