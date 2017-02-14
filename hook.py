from selenium import webdriver
import sys
import argparse

"""
Selenium WebDriver Reconnection

This allows python to directly connect to a running chreomdriver session.
Any program running a chrome webdriver can pass in:
                -> driver.command_executor._url
                -> driver.session_id

This is a basic example that will allow python to run along side other programming languages to handle
heavy macro automation and quick scripting.

"""
driver = None

if __name__ == '__main__':
    global driver

    parser = argparse.ArgumentParser()
    parser.add_argument('-c', '--connect', nargs=2, metavar=('URL', 'SESSIONID'), help='Hook python to a running chromedriver session')
    parser.add_argument('-k', '--kill', action='store_true', help='Unhook python from the driver')


    args = vars(parser.parse_args())

    if args['connect']:
        """
        Get driver url and driver session id from input
        """
        url = args['connect'][0]
        session_id = args['connect'][1]

        """
        Create a driver session using the driver url from another driver
        """
        driver = webdriver.Remote(command_executor=url, desired_capabilities={})
        """
        Close the opened driver window. It does not kill the process chromedriver.exe
        """
        driver.close()
        """
        Set the driver session_id to the already opened session_id
        """
        driver.session_id = session_id
        """
        Now python is connected to the process.

        Here is an example of it going to a website
        """
        driver.get("http://www.stackoverflow.com")

    if args['kill']:
        """
        Close driver connection session
        """
        driver.close()
        """
        Close chromedriver.exe
        """
        driver.quit()
        """
        Close the script and python process
        """
        sys.exit()
