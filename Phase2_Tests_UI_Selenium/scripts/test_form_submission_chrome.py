import time
import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def test_form_submission(setup):
    driver = setup
    driver.get("https://formy-project.herokuapp.com/form")

    # Remplissage du formulaire
    driver.find_element(By.ID, "first-name").send_keys("Ayoub")
    driver.find_element(By.ID, "last-name").send_keys("Bentalia")
    driver.find_element(By.ID, "job-title").send_keys("QA Engineer")

    # Sélection radio button (Highest level of education)
    driver.find_element(By.ID, "radio-button-2").click()

    # Sélection checkbox
    driver.find_element(By.ID, "checkbox-1").click()

    # Sélection dans la liste déroulante
    dropdown = driver.find_element(By.ID, "select-menu")
    dropdown.click()
    option = driver.find_element(By.CSS_SELECTOR, "option[value='1']")
    option.click()

    # Saisir la date
    driver.find_element(By.ID, "datepicker").send_keys("10/14/2025")

    # Cliquer sur Submit
    driver.find_element(By.CSS_SELECTOR, ".btn.btn-lg.btn-primary").click()

    # Attente explicite de la page de confirmation
    try:
        success_msg = WebDriverWait(driver, 10).until(
            EC.presence_of_element_located((By.CLASS_NAME, "alert"))
        )
        assert "The form was successfully submitted!" in success_msg.text
        print("✅ Soumission réussie : le message de succès est affiché.")
    except Exception as e:
        driver.save_screenshot("../screenshots/test_form_submission_error.png")
        pytest.fail(f"❌ Échec lors de la soumission du formulaire : {e}")

    # Capture finale si tout est OK
    driver.save_screenshot("../screenshots/test_form_submission.png")
    time.sleep(2)
