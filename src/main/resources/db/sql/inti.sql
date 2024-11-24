INSERT INTO "authors" ("id", "age", "description", "image", "name")
VALUES (1, 40,
        'Margaret Garcia, a literary luminary, crafts stories with an intellectual allure. Her works resonate with the essence of smart writing, weaving intricate narratives that captivate the mind and heart.',
        'author-margaret.png', 'Margaret Garcia'),
       (2, 55,
        'Penelope Ólafsdóttir, a maestro of whimsy, paints tales with a brush of enchantment. Her storytelling dances with magic, inviting readers into whimsical realms where imagination knows no bounds.',
        'penelope.png', 'Penelope Ólafsdóttir'),
       (3, 50,
        'Olivia Sinclair, a virtuoso of prose, intertwines compelling narratives with profound moral insight. Her stories resonate with timeless values, illuminating the human spirit with wisdom and compassion.',
        'author-olivia.png', 'Olivia Sinclair'),
       (4, 28,
        'Benjamin Swift, a master of exhilaration, pens tales that pulse with excitement. His narratives are a rollercoaster of thrills, immersing readers in gripping adventures that leave them breathless and eager for the next twist.',
        'author-benjamin.png', 'Benjamin Swift'),
       (5, 48,
        'Felix Lee, the maestro of suspense, crafts narratives that ride the edge of unpredictability. With a penchant for plot twists, his stories are labyrinthine journeys that keep readers guessing until the final, electrifying revelation',
        'felix.png', 'Felix Lee'),
       (6, 42,
        'Evelyn Harper, a storyteller rooted in simplicity, weaves tales with a down-to-earth charm. Her narratives resonate with authenticity, inviting readers into relatable worlds where the beauty of everyday life unfolds in eloquent prose.',
        'evelyn-harper.png', 'Evelyn Harper'),
       (7, 45,
        'Serena Monroe, a maestro of meticulous research, crafts narratives with well-woven plots. Her stories are a tapestry of depth and authenticity, where every detail resonates with precision and enriches the reader''s journey.',
        'author-serena.png', 'Serena Monroe'),
       (9, 32,
        'Ava Davis, a storyteller of heart and soul, spins wholesome tales that embrace readers with warmth. Her narratives, like comforting blankets, weave a tapestry of love, kindness, and genuine connections in every page.',
        'ava.png', 'Ava Davis'),
       (10, 38,
        'Max Williams, a wordsmith of wit, weaves humor into every page. His tales are a lively dance of humor, offering readers a delightful escape into worlds where laughter reigns supreme.',
        'Max.png', 'Max Williams');
INSERT INTO "books" ("isbn", "description", "image", "title", "author_id")
VALUES ('978-1-234567-92-3',
        'In a world of circuits and steel, ''Steel Bonds'' unfolds the poignant tale of two robot brothers, Atom and Byte, separated by fate and reunited by destiny. Atom, designed for exploration, embarks on a cosmic journey across galaxies. Byte, engineered for knowledge, remains on Earth, grappling with the passage of time. Their paths converge after eons, triggering an emotional reunion that sparks a cosmic adventure. As they navigate the complexities of artificial emotions, their unique abilities become the key to solving a galactic mystery threatening the very fabric of robotic existence. ''Steel Bonds'' explores themes of family, identity, and the unbreakable ties that bind us. Through binary heartbeats, Atom and Byte rediscover the strength in unity, confronting challenges that transcend their mechanical origins. Will their shared memories and newfound purpose be enough to overcome the cosmic chaos threatening both man-made and metallic worlds? Join Atom and Byte in ''Steel Bonds,'' a riveting journey where the clash of gears echoes the heartbeat of brotherhood. This sci-fi odyssey delves into the essence of what it means to be alive, even when your heart is made of ones and zeros. In the realm of wires and stardust, the reunion of two robot brothers becomes a testament to the enduring power of familial love in a universe woven with threads of steel.',
        'book-steel-bonds.png', 'Steel Bonds', 5),
       ('978-1-234567-94-5',
        'Prepare for an exhilarating dive into the spectacularly uneventful world of dolphins in ''Mundane Dolphins.'' Join our cetacean protagonists as they embark on the thrilling journey of... swimming. Yes, you read that right—swimming. But not just any swimming; it''s the kind of swimming that involves dorsal fins cutting through the water with an almost awe-inspiring lack of excitement. Hold your breath (unlike our dolphins, who need to breathe regularly) as these marine maestros engage in the captivating art of echolocation. Witness the sheer thrill of locating fish, a task so routine it makes watching paint dry seem like a roller coaster ride. But that''s not all—brace yourself for the heart-pounding spectacle of synchronized swimming, where dolphins move in coordinated patterns that might just leave you yawning with sheer exhilaration. And let''s not forget the breathtaking moments of leaping and splashing, events so adrenaline-packed they might make you question if you accidentally stumbled into a riveting nature documentary. ''Mundane Dolphins'' is the unmissable journey into the riveting mundanity of dolphinality. Experience the monotony, revel in the predictability, and prepare for the staggering lack of unexpected twists that make the daily routine of dolphins a tour de force in the world of aquatic humdrum.',
        'mundane-dolphins.png', 'Mundane Dolphins', 10),
       ('978-1-234567-90-1',
        'In the enchanted town of Snowhaven, a magical snowman named Frost embarks on an extraordinary coming-of-age journey. As winter sets in, Frost discovers the power within to shape his destiny. Battling self-doubt and a melting existence, Frost befriends a spirited snowflake companion and encounters a wise old icicle mentor. ''Frostbound Odyssey'' follows Frost''s quest to discover his purpose in the fleeting world of snow and ice. With each snowfall, he learns the importance of self-acceptance and the beauty of embracing change. As spring approaches, Frost must confront the inevitability of melting, challenging him to leave a lasting impact on Snowhaven. This heartwarming tale explores themes of identity, friendship, and the transient nature of life. Will Frost find meaning in his ephemeral existence, or will he fade away like the winter sun? Join Frost in this enchanting adventure, where the warmth of self-discovery meets the chill of a magical winter''s tale.',
        'frostbound-odyssey.png', 'Frostbound Odyssey', 9),
       ('978-1-234567-95-6',
        'In the heart-pounding world of ''Skybound Rivalry,'' meet Jack Windrider, a man consumed by an obsession with paragliding. Convinced he owns the sky, Jack spirals into a bizarre quest to assert dominance. Birds, planes, and fellow paragliders become his mortal enemies as he takes to the skies, determined to knock anything and everything out of his claimed territory. As Jack soars through the clouds, his airborne vendetta creates chaos in the heavens. The skies transform into a battleground, with Jack unleashing his paragliding prowess against unsuspecting airborne intruders. Will Jack''s reckless pursuit of sky supremacy lead to triumph or a perilous fall from grace? ''Skybound Rivalry'' is a thrilling tale that explores the fine line between passion and obsession. Jack''s aerial adventures become a daring escapade where the sky is no longer a boundless expanse but a contested realm. Join Jack as he navigates the turbulent currents of his own ambition, challenging the very elements that define his existence in this high-flying drama where the sky is not the limit—it''s the battlefield.',
        'skybound-rivalry.png', 'Skybound Rivalry', 4),
       ('978-1-234567-89-0',
        'In Felinia, Ember, a spirited ginger cat, sets off on a heroic journey foretold by an ancient prophecy. Armed with courage and a mysterious amulet, Ember befriends a wise mentor, a mischievous trickster, and a daring warrior. As they navigate magical landscapes and face treacherous foes, Ember learns the true meaning of friendship, loyalty, and sacrifice. In a world where whiskers hold the key to destiny, Ember''s paws leave an indelible mark on the path to confront Shadowclaw, an ancient adversary threatening Felinia''s harmony. \"Whiskers of Destiny\" is a heartwarming tale exploring the resilience of the feline spirit, where the truest hero emerges with a heart ablaze with destiny. Will Ember''s whiskers be enough to save Felinia, or will Shadowclaw cast an everlasting shadow? Find out in this epic adventure, proving heroes come in all shapes and sizes, even with a splash of ginger fur.',
        'book-whiskers-of-destiny.png', 'The Whiskers of Destiny', 6),
       ('978-1-234567-95-7',
        'In the whimsical world of ''The Drizzle Dilemma,'' meet Dewdrop, a tiny creature with an unusual predicament—he would melt if he got wet, yet he harbors an inexplicable love for the rain. As the skies open up, Dewdrop faces the challenge of indulging in his passion without succumbing to the perilous touch of water. This heartwarming tale follows Dewdrop''s quest to experience the magic of raindrops without sacrificing his delicate existence. From crafting ingenious rain shelters to dancing beneath oversized leaves, Dewdrop''s creative endeavors reveal the resilience of a small creature with big dreams. As Dewdrop navigates the charming intricacies of his rain-loving world, he discovers the transformative power of courage, ingenuity, and a steadfast love for life''s simplest joys. Will Dewdrop find a way to embrace the rain without compromising his delicate nature, or will his love for the drizzle lead to an unexpected and watery fate? ''The Drizzle Dilemma'' invites readers into a miniature world where the smallest beings harbor the biggest dreams. Join Dewdrop on this enchanting journey as he seeks to reconcile his love for rain with the fragility of his existence, proving that sometimes, the tiniest creatures can inspire the most extraordinary tales.',
        'drizzle-dilemma.png', 'The Drizzle Dilemma', 7),
       ('978-1-234567-91-2',
        'In a dystopian world where the skies are tainted with despair, Zara, an empathetic alien, arrives with a passion for fishing. Despite their extraterrestrial origin, Zara finds solace in Earth''s waters. As societal chaos ensues, Zara''s piscatorial pursuits become a metaphor for hope. ''Angler''s Odyssey'' unveils Zara''s journey, navigating a desolate landscape where humanity struggles. Armed with a fishing rod and an otherworldly perspective, Zara forms unlikely alliances with survivors, teaching them the art of patience and resilience. Together, they discover that amidst the ruins, the therapeutic rhythm of casting lines echoes defiance against the darkness. This dystopian tale interweaves the struggles of survival with Zara''s love for fishing, creating a narrative that transcends worlds. As alliances fray and desperation rises, Zara''s extraterrestrial wisdom becomes a beacon of unity. Will Zara''s wisdom guide Earth''s remnants to a new beginning, or will the shadows of despair engulf their last glimmer of hope? ''Angler''s Odyssey'' is a poignant exploration of the human spirit''s tenacity, seen through the eyes of an alien who found solace in the simplicity of a fishing line. Join Zara in this otherworldly adventure, where the pursuit of serenity in the midst of chaos becomes a powerful testament to the enduring connection between beings, regardless of their origins.',
        'beyond-the-abyss.png', 'Beyond the Abyss: A Fisherman''s Tale', 1),
       ('978-1-234567-93-4',
        'In the far reaches of the cosmos, the fate of worlds hangs in the balance as the most extraordinary intergalactic ultimate space disk tournament commences. ''Galaxy''s Last Toss'' pits elite teams against each other in a cosmic showdown, where victory secures survival, and defeat heralds the destruction of one''s home planet. Follow the adrenaline-fueled journey of Team Nebula as they navigate gravity-defying space disk matches across celestial arenas. Led by Captain Solaris and fueled by the determination to save their beloved worlds, the team faces extraterrestrial opponents, each with unique space disk-wielding skills. As the tournament progresses, alliances form, rivalries ignite, and the fate of entire civilizations hinges on every throw and catch. Will Team Nebula defy the odds and emerge as champions, or will the galactic stakes lead to the annihilation of their planets? In this cosmic spectacle, the spirit of competition takes on a newfound gravity, transcending sportsmanship to become a fight for the very survival of the cosmos. ''Galaxy''s Last Toss'' is a thrilling, high-stakes adventure that combines the excitement of intergalactic sports with the epic drama of a universe on the brink. Join Team Nebula as they soar through space, aiming for victory in the ultimate space disk tournament that determines the destiny of worlds. Prepare for a journey where each toss becomes a symbol of hope and every catch a step toward cosmic salvation.',
        'galaxys-last-toss.png', 'Galaxy''s Last Toss', 3);
