from selenium import webdriver
import os

PATH = os.path.dirname(os.path.realpath(__file__))


chromedriver = os.path.join(PATH, "chromedriver.exe")
os.environ["webdriver.chrome.driver"] = chromedriver
options = webdriver.ChromeOptions()
options.add_experimental_option("excludeSwitches", ["ignore-certificate-errors"])
driver = webdriver.Chrome(chromedriver)

