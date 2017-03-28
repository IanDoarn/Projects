using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace gitty
{
    class Utils
    {
        public static string Menu()
        {
            string menu = "Gitty usage:\n\n" +
                          "-u\tUpdate settings\n" +
                          "-g\tEnter Git\n" +
                          "-e\tExit";        
            return menu;
        }

        public static void updateSettingsItem(dynamic settingsItem, dynamic value)
        {
            settingsItem = value;
            settingsItem.Save();
        }

        public static dynamic askUser(string message, string submessage, dynamic defaultReturn = null)
        {
            Console.WriteLine(message + " ? Y/N:");
            string response = Console.ReadLine();

            if (!(response.ToUpper() == "Y"))
            {
                if (submessage == null)
                {
                    return defaultReturn;
                }

                Console.WriteLine(submessage);
                return Console.ReadLine();
            }

            return defaultReturn;
        }

        public static void updateArg(string arg)
        {
            if (!(arg.Length > 2))
            {
                Console.WriteLine("Must pass argurment of setting name:\n-u [SETTINGKEY] [VALUES...]");
                Environment.Exit(0);
            }
            else
            {
                string[] args = arg.Split(' ');

                if (args[2].Contains("help"))
                {
                    Console.WriteLine("Available Keys:\nhelp\nroot\ngit\nlogin");
                }
                else if (args[1] == "root")
                {
                    updateSettingsItem(Settings.Default.root, args[2]);
                    Console.WriteLine("Root now at: " + Settings.Default.root);
                }

                else if (args[1] == "git")
                {
                    string gitExe = "";

                    if (args[2] == null)
                    {
                        try
                        {
                            gitExe = Environment.GetEnvironmentVariable("ProgramFiles") + "\\Git\\cmd\\git.exe";
                        }
                        catch (Exception e)
                        {
                            Console.WriteLine(e.Message.ToString());
                        }
                        finally
                        {
                            Console.WriteLine("Please enter git.exe location: ");
                            gitExe = Console.ReadLine();
                            updateSettingsItem(Settings.Default.gitexecutable, gitExe);
                        }
                    }

                    updateSettingsItem(Settings.Default.gitexecutable, args[2]);
                    Environment.Exit(0);


                }

                else if (args[1] == "login")
                {
                    if (args.Length < 3)
                    {
                        Console.WriteLine("Invalid number of arguments for " + args[1] + ".\nRequired: [USER] [PASS]");
                        Environment.Exit(0);
                    }

                    updateSettingsItem(Settings.Default.username, args[2]);
                    updateSettingsItem(Settings.Default.username, args[3]);
                }
            }        
        }
    }
}
