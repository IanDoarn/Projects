using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace gitty
{
    class Program
    {

        static void Main(string[] args)
        {
            parseArgument(string.Join(" ", args));
        }
        private static void gitMain()
        {
            string gitExe = "";
            string rootDirectory = Settings.Default.root;

            if (Settings.Default.root == "none")
            {
                rootDirectory = Utils.askUser("User default root [" + Settings.Default.root + "]", "Enter root directory: ", @"C:\Users\");
                bool saveRoot = Utils.askUser("Save [" + rootDirectory + "] as default root?", null, true);
                if (saveRoot)
                {
                    Settings.Default.root = rootDirectory;
                    Settings.Default.Save();
                }

            }

            Console.WriteLine("Root directory at " + rootDirectory);
            Console.WriteLine("Enter project directory: ");
            string projectDirectory = Console.ReadLine();

            Console.WriteLine("Enter commit note: ");
            string commitNote = Console.ReadLine();

            string pushType = Utils.askUser("Use force push?", "Enter push type: ", Settings.Default.pushCommand);

            if(Settings.Default.gitexecutable == "none")
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
                    Settings.Default.gitexecutable = gitExe;
                    Settings.Default.Save();
                }
            }

            gitExe = Settings.Default.gitexecutable;

            try
            {
                git(gitExe, addFiles());
                git(gitExe, commit(commitNote));
                git(gitExe, push(pushType));

            }
            catch(Exception e)
            {
                Console.WriteLine("Error occurred while running gitty");
                Console.WriteLine(e.Message.ToString());
            }
            finally
            {
                close();
            }

            close();

        }

        private static void close()
        {
            Console.Write("Press any key to exit or close the window.");
            Console.ReadKey();
            Environment.Exit(0);
        }
        private static void git(string gitExecutableLocation ,string command)
        {
            string gitExecutable = gitExecutableLocation;

            Process process = new Process();
 
            process.StartInfo.UseShellExecute = false;
            process.StartInfo.FileName = gitExecutable;
            process.StartInfo.Arguments = command;
            process.Start();
            process.WaitForExit();
        }

        private static string addFiles(string files=".")
        {
            if(!(files == "."))
            {
                string[] allFiles = files.Split(',');
                files = string.Join(" ", allFiles);
                return "git add " + files;
            }
            return "add " + files;
        }

        private static string commit(string commitNote="")
        {
            if(!(commitNote == ""))
            {
                return "commit -m \"\"";
            }

            return "commit -m \"" + commitNote + "\"";
        }

        private static string push(string pushType="-f")
        {
            if(!(pushType == "-f"))
            {
                return "push " + pushType;
            }

            return "push " + pushType;
        }


        private static void parseArgument(string arg)
        {
            if((arg == "-h" || arg == "--help"))
            {
                Console.WriteLine(Utils.Menu());
                Environment.Exit(0);
            }

            else if (arg == "-u")
            {
                Utils.updateArg(arg);
            }
        }
    }
}
