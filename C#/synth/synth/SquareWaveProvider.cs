using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace synth
{
    public class SquareWaveProvider32 : WaveProvider32
    {
        int sample;

        public SquareWaveProvider32()
        {
            Frequency = 100;
            Amplitude = 0.10f;          
        }

        public float Frequency { get; set; }
        public float Amplitude { get; set; }

        public override int Read(float[] buffer, int offset, int sampleCount)
        {
            int sampleRate = WaveFormat.SampleRate;
            for (int n = 0; n < sampleCount; n++)
            {
                buffer[n + offset] = (Amplitude * Math.Sign(Math.Sin(Frequency * n)));
                sample++;
                if (sample >= sampleRate) sample = 0;
            }
            return sampleCount;
        }
    }
}
