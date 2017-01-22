'''
Basic example of a encryption algorithm
The requires an encryption key, either using the default one or a self created one.
Normally keys are not hardcoded but for the sake of this example, one is.
Create by: Ian Doarn
'''
import convert

'''Generic encryption key'''
key = {"A": "u", "B": "w",
       "C": "e", "D": "r",
       "E": "z", "F": "y",
       "G": "q", "H": "i",
       "I": "o", "J": "p",
       "K": "a", "L": "s",
       "M": "b", "N": "f",
       "O": "g", "P": "h",
       "Q": "j", "R": "k",
       "S": "l", "T": "t",
       "U": "x", "V": "c",
       "W": "v", "X": "d",
       "Y": "n", "Z": "m",
       "1": "*", "2": "#",
       "3": "&", "4": "_",
       "5": "%", "6": "@",
       "7": ";", "8": "+",
       "9": "[", "0": "!",
       "!": "R", "@": "#",
       ".": "3"}


class Algorithm:

    '''Defining key, key_id, offset, base_type, obj type, and concatenation length'''

    def __init__(self, key=key, key_id='$', offset=5, b_type=16, i_type=str, concat=2):
        self.key_codes = {'offset': offset,
                          'key': key,
                          'id': key_id,
                          'b_type': b_type,
                          'type': i_type,
                          'concat': concat}

        '''Basic encryption algorithm:
            Starting at the offset number till to the length of the text,
            for every character as a dict key index get is respective value from the encryption key,
            put them together, this will be the hash.
            Next, take each letter in out hash, convert it to a hex code, then combine these together
            this will give us our private key.
            We prefix the private key wit more encrypted information, the first character is out key_id.
            The characters between out key_id and the = sign is original passwords length. These characters are assigned the
            same way the hash is made, using our encryption key.
            Finally, our suffix is again encrypted information, this tells us the offset number for out algorithm.
        '''
    def encrypt(self, text):
        '''Load conversion script with base16'''
        c = convert.Convert(base=self.key_codes['b_type'],
                            val_type=self.key_codes['type'])

        offset = self.key_codes['offset']
        s_length = str(len(text))
        l_list = list(text.upper())
        n_list = []
        h_list = []
        '''If text is longer than 9 characters'''
        if len(text) > 9:
            for l in l_list:
                h_list.append(self.key_codes['key'][l])
                l_key = c.ascii_to_base_16(self.key_codes['key'][l])[0]
                n_list.append(l_key)

            return {'id': self.key_codes['id'],
                    "private_key": ''.join(n_list),
                    "hash": ''.join(h_list)[::-1],
                    "prefix": self.key_codes['id'] +
                              self.key_codes['key'][s_length[:1]] + self.key_codes['key'][s_length[1:]] +
                              '=',
                    "suffix": '=' + self.key_codes['key'][str(offset)]}
        else:
            for l in l_list:
                h_list.append(self.key_codes['key'][l])
                l_key = c.ascii_to_base_16(self.key_codes['key'][l])[0]
                n_list.append(l_key)

            return {'id': self.key_codes['id'],
                    "private_key": ''.join(n_list),
                    "hash": ''.join(h_list)[::-1],
                    "prefix": self.key_codes['id'] +
                              self.key_codes['key'][s_length] +
                              '=',
                    "suffix": '=' + self.key_codes['key'][str(offset)]}

    '''Basic Decryption
        Simply put, do what we did with encryption but backwards!
        First, we take an input of a hash and a private key.
        We split the private key on the = sigh to give us out prefix and suffix information.
        We convert the hash to hex, binary base16, anf add the prefix to the beginning of it with and = sign.
        If this equals our private key then we can decrypt our hash, if not then an error is raised.
        We determine if the prefix is a single or double integer. At the same time we get the offset and and pass length by
        checking our characters against each value in the original encryption key.
        If we find a match we get the original numbers / values. These numbers are the offset and the original passwords
        length
        Next, we split the hexadecimal hash into groups based on the concat value. We convert each hex value back to base10 and
        get the character associated with that number using the built-in chr()
        While parsing through out encryption key and combining decrypted characters, if the built string equals
        the original password length, we break out loop and return the finished string.
    '''
    def decrypt(self, hash, private_key):
        hash = hash[::-1]
        c = convert.Convert(base=self.key_codes['b_type'],
                            val_type=self.key_codes['type'])

        if private_key.split('=')[0] + '=' + ''.join(c.ascii_to_base_16(hash)) + '=' + private_key.split('=')[2] == private_key:
            n = self.key_codes['concat']
            keys = self.key_codes['key']
            obj = private_key.split('=')
            prefix = ''
            offset = obj[2]
            crypt = obj[1]
            c_hash = ''
            origin_length = 0
            unhash = ''

            '''Get prefix code'''
            if len(obj[0]) == 3:
                prefix = list(obj[0])[1:3]
            else:
                prefix = list(obj[0])[1:2]

            '''Get offset and original pass length'''
            if len(prefix) == 2:
                l = ''
                for k, v in keys.items():
                    if v == prefix[0]:
                        l = l + k
                        break
                for k, v in keys.items():
                    if v == prefix[1]:
                        l = l + k
                        break
                origin_length = int(l)
            elif len(prefix) == 1:
                for k, v in keys.items():
                    if v == prefix[0]:
                        origin_length = int(k)
            for k, v in keys.items():
                if v == offset:
                    offset = int(k)

            '''Use concat key to split hash into respective groups'''
            c_hash = [crypt[i:i + n] for i in range(0, len(crypt), n)]

            '''begin decryption'''
            for hex_val in c_hash:
                key_v = str(chr(int(hex_val, 16)))
                for k, v in keys.items():
                    if v == key_v:
                        if len(unhash) != origin_length:
                            unhash += k.lower()
                        elif len(unhash) == origin_length:
                            break

            return {'offset': offset, 'length': origin_length, 'un_hash': unhash}
        else:
            print('Incorrect Private Key')



"""Basic Usage
    Initialize the class Algorithm, if you want pass other keyword args into it.
    Default kwargs (key=key, key_id='$', offset=5, b_type=16, i_type=str, concat=2)
    To encrypt you can either us the default encryption key or make your own!
    here is the default:
    key = {"A": "q", "B": "w",
           "C": "e", "D": "r",
           "E": "t", "F": "y",
           "G": "u", "H": "i",
           "I": "o", "J": "p",
           "K": "a", "L": "s",
           "M": "d", "N": "f",
           "O": "g", "P": "h",
           "Q": "j", "R": "k",
           "S": "l", "T": "z",
           "U": "x", "V": "c",
           "W": "v", "X": "b",
           "Y": "n", "Z": "m",
           "1": "*", "2": "#",
           "3": "&", "4": "_",
           "5": "%", "6": "@",
           "7": ";", "8": "+",
           "9": "[", "0": "!",
           "!": "R"}
    To decrypt you must have the encryption key, hash, and private key
    Algorithm().encrypt(text) returns: {id, private key, hash, prefix, suffix}
    Algorithm().decrypt(hash, private_key) returns: {offset, length, un_hash}
#Uncomment this section below to see how this works!
"""

if __name__ == '__main__':
    a = Algorithm()

    hash = a.encrypt('johnnybravo')
    print('hash: ' + hash['hash'])

    p_key = hash['prefix'] + hash['private_key'] + hash['suffix']
    password = a.decrypt(hash['hash'], p_key)

    print('private key: ' + p_key)
    print('un_hash: ' + password['un_hash'])
