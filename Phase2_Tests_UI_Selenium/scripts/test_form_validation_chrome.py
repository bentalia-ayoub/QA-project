import time
import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def test_form_validation(setup):
    driver = setup
    driver.get("https://formy-project.herokuapp.com/form")

    # Attendre que le champ first-name soit visible
    first_name_field = WebDriverWait(driver, 10).until(
        EC.visibility_of_element_located((By.ID, "first-name"))
    )

    # Vérifier si le champ est bien visible
    assert first_name_field.is_displayed(), "Le champ 'First name' n'est pas visible"

    # Vérifier qu'il n'a PAS d'attribut 'required'
    is_required = first_name_field.get_attribute("required")
    print(f"Attribut 'required' du champ First name : {is_required}")

    # On considère le test comme validé si le champ est présent (et visible)
    assert is_required is None, "Le champ 'First name' est défini comme obligatoire à tort"

    # Capture d’écran pour preuve
    driver.save_screenshot("../screenshots/test_form_validation.png")
