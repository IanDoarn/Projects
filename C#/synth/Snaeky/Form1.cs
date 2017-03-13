using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using NAudio;
using NAudio.Wave;
using System.Threading;

namespace Snaeky
{
    public partial class Form1 : Form
    {
        private static WaveOut waveOut;
        public SineWaveProvider32 sineWaveProvider;
        public SquareWaveProvider32 squareWaveProvider;
        public dynamic currentWave;
        private static int freq = 1000;
        private static int desLat = 200;

        public Form1()
        {
            InitializeComponent();
            
        }

        private SineWaveProvider32 sinewave()
        {
            sineWaveProvider = new SineWaveProvider32();
            sineWaveProvider.SetWaveFormat(16000, 1); // 16kHz mono
            sineWaveProvider.Frequency = freq;
            sineWaveProvider.Amplitude = 0.25f;

            return sineWaveProvider;
        }
        private  SquareWaveProvider32 squarewave()
        {
            squareWaveProvider = new SquareWaveProvider32();
            squareWaveProvider.SetWaveFormat(8000, 1);

            squareWaveProvider.Frequency = freq;
            squareWaveProvider.Amplitude = 0.25f;

            return squareWaveProvider;
        }
        private void __play()
        {
            

            if (checkBox1.Checked)
            {
                currentWave = sinewave();
                currentWave.Frequency = freq;
                waveOut = new WaveOut();
                waveOut.DesiredLatency = desLat;
                waveOut.NumberOfBuffers = trackBar2.Value;
                waveOut.Init(currentWave);
                waveOut.Play();
            }
            else if (checkBox2.Checked)
            {
                currentWave = squarewave();
                currentWave.Frequency = freq * 2;
                waveOut = new WaveOut();
                waveOut.DesiredLatency = desLat;
                waveOut.NumberOfBuffers = trackBar2.Value;
                waveOut.Init(currentWave);
                waveOut.Play();
            }
        }

        private void __stop()
        {
            try
            {
                waveOut.Stop();
                waveOut.Dispose();
                waveOut = null;
                currentWave = null;
            }
            catch
            {

            }
        }

        private void button1_Click(object sender, EventArgs e)
        {      
            __play();
        }

        private void button2_Click(object sender, EventArgs e)
        {     
            __stop();
        }

        private void trackBar1_Scroll(object sender, EventArgs e)
        {
            try
            {
                currentWave.Frequency = trackBar1.Value;
            }
            catch
            {

            }
        }

        private void trackBar2_Scroll(object sender, EventArgs e)
        {
            try
            {
                waveOut.NumberOfBuffers = trackBar2.Value;
            }
            catch
            {

            }

        }
    }
}
