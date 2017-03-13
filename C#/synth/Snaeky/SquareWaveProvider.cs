using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Snaeky
{
    public class SquareWaveProvider32 : WaveProvider32
    {
        int sample;
        

        public SquareWaveProvider32()
        {
            Frequency = 1000;
            Amplitude = 0.10f;
        }

        public float Frequency { get; set; }
        public float Amplitude { get; set; }

        public override int Read(float[] buffer, int offset, int sampleCount)
        {
            double angle = (Math.PI * 2 * Frequency) / (44100 * 2);

            int sampleRate = WaveFormat.SampleRate;
            
            for (int n = 0; n < sampleCount; n++)
            {
                if(Math.Sin(angle * n) > 0)
                {
                    buffer[n] = Amplitude;
                    sample++;
                    if (sample >= (int)(sampleRate / Frequency)) sample = 0;
                }
                else
                {
                    buffer[n] = -Amplitude;
                    sample++;
                    if (sample >= (int)(sampleRate / Frequency)) sample = 0;
                }
                
            }
            return sampleCount;
        }
    }
}
