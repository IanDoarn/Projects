using NAudio;
using NAudio.Wave;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace synth
{
    class Program
    {
        private static WaveOut waveOut;

        static void Main(string[] args)
        {
            StartStopSquareWave();
        }
        private static void StartStopSineWave()
        {
            var sineWaveProvider = new SineWaveProvider32();
            sineWaveProvider.SetWaveFormat(16000, 1); // 16kHz mono
            sineWaveProvider.Frequency = 1000;
            sineWaveProvider.Amplitude = 0.25f;

            waveOut = new WaveOut();
            waveOut.Init(sineWaveProvider);
            waveOut.Play();
            Thread.Sleep(1000);
            waveOut.Stop();
            waveOut.Dispose();
            waveOut = null;
        }

        private static void StartStopSquareWave()
        {
            var SquareWaveProvider = new SquareWaveProvider32();
            SquareWaveProvider.SetWaveFormat(8000, 1);

            waveOut = new WaveOut();
            waveOut.NumberOfBuffers = 250;
            waveOut.Init(SquareWaveProvider);
            waveOut.Play();
            Thread.Sleep(1000);
            waveOut.Stop();
            waveOut.Dispose();
            waveOut = null;
        }
    } 
}
