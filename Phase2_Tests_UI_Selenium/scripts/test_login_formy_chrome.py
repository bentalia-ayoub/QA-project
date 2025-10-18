from selenium.webdriver.common.by import By
import time

def test_login_formy(setup):
    driver = setup
    driver.get("https://formy-project.herokuapp.com/form")
    
    # Remplir le formulaire
    driver.find_element(By.ID, "first-name").send_keys("Ayoub")
    driver.find_element(By.ID, "last-name").send_keys("Bentalia")
    driver.find_element(By.ID, "job-title").send_keys("Développeur Full Stack")
    
    # Sélectionner des options
    driver.find_element(By.ID, "radio-button-2").click()
    driver.find_element(By.ID, "checkbox-1").click()
    
    # Envoyer le formulaire
    driver.find_element(By.CSS_SELECTOR, ".btn.btn-lg.btn-primary").click()
    
    time.sleep(2)  # pause pour voir le résultat
    
    # Vérifier que le message de succès apparaît
    success_text = driver.find_element(By.CLASS_NAME, "alert").text
    assert "The form was successfully submitted!" in success_text
