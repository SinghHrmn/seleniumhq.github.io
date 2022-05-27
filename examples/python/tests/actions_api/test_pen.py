import math
from time import time

from selenium.webdriver.common.actions.action_builder import ActionBuilder
from selenium.webdriver.common.actions.interaction import POINTER_PEN
from selenium.webdriver.common.by import By


def test_use_pen(driver):
    driver.get('https://www.selenium.dev/selenium/web/pointerActionsPage.html')
    start = time()

    rect = driver.find_element(By.ID, "pointerArea").rect
    action = ActionBuilder(driver, duration=800)
    action.add_pointer_input(POINTER_PEN, "default pen")
    action.pointer_action\
        .move_by(rect["x"] + 5, rect["y"] + 5)\
        .pointer_down(0)
    action.pointer_action\
        .move_by(2, 2)\
        .pointer_up(0)
    action.perform()

    assert time() - start > 1.6

    moves = driver.find_elements(By.CLASS_NAME, "pointermove")
    move_to = properties(moves[0])
    down = properties(driver.find_element(By.CLASS_NAME, "pointerdown"))
    move_by = properties(moves[1])
    up = properties(driver.find_element(By.CLASS_NAME, "pointerup"))

    assert move_to["button"] == "-1"
    assert move_to["pageX"] == str(math.floor(rect["x"] + 5))
    assert move_to["pageY"] == str(math.floor(rect["y"] + 5))
    assert down["button"] == "0"
    assert down["pageX"] == str(math.floor(rect["x"] + 5))
    assert down["pageY"] == str(math.floor(rect["y"] + 5))
    assert move_by["button"] == "-1"
    assert move_by["pageX"] == str(math.floor(rect["x"] + 5 + 2))
    assert move_by["pageY"] == str(math.floor(rect["y"] + 5 + 2))
    assert up["button"] == "0"
    assert up["pageX"] == str(math.floor(rect["x"] + 5 + 2))
    assert up["pageY"] == str(math.floor(rect["y"] + 5 + 2))


def properties(element):
    kv = element.text.split(' ', 1)[1].split(', ')
    return {x[0]:x[1] for x in list(map(lambda item: item.split(': '), kv))}


